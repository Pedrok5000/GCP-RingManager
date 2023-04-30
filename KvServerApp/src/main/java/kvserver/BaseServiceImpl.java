package kvserver;

import clientToKvServer.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import kvServerToKvServer.ReadRequest;
import kvServerToKvServer.Result;
import kvServerToKvServer.RingServiceGrpc;
import kvServerToKvServer.WriteRequest;
import kvServerToManager.KvServerInfo;
import kvServerToManager.NextServer;
import kvServerToManager.RegisterServiceGrpc;
import redis.clients.jedis.Jedis;

public class BaseServiceImpl extends BaseServiceGrpc.BaseServiceImplBase {

    private final String myInfo;
    private final String managerInfo;
    private final NextServerInfo nextServerInfo;
    private final Jedis jedis;

    // stubs
    private static RingServiceGrpc.RingServiceBlockingStub ringServiceBlockingStub;
    private static RegisterServiceGrpc.RegisterServiceBlockingStub registerServiceBlockingStub;

    private static ManagedChannel channel;

    public BaseServiceImpl(Jedis jedis, String managerInfo, String myInfo, NextServerInfo nextServerInfo) {
        this.jedis = jedis;
        this.myInfo = myInfo;
        this.nextServerInfo = nextServerInfo;
        this.managerInfo = managerInfo;
    }

    public void writeUpdate(KeyValue request, StreamObserver<Reply> resSO) {
        System.out.println("> received write request from client");

        jedis.set(request.getKey(), request.getValue());
        Reply reply = Reply.newBuilder().setReply("Value stored!").build();
        resSO.onNext(reply);
        resSO.onCompleted();

        String[] info = nextServerInfo.getNextServer().split(":");

        // propagar pedido
        try {
            channel = ManagedChannelBuilder
                    .forAddress(info[0], Integer.parseInt(info[1]))
                    .usePlaintext()
                    .build();

            ringServiceBlockingStub = RingServiceGrpc.newBlockingStub(channel);

            WriteRequest writeRequest = WriteRequest.newBuilder()
                    .setKey(request.getKey())
                    .setValue(request.getValue())
                    .setOriginServer(myInfo)
                    .build();

            System.out.println("> sending writeNext to: " + info[0] + ":" + info[1]);
            kvServerToKvServer.Reply replyNext = ringServiceBlockingStub.writeNext(writeRequest);
            System.out.println("> writeNext reply: " + replyNext.getReply());

        } catch (StatusRuntimeException e) {
            // informFail
            System.out.println("> " + info[0] + ":" + info[1] + " isn't responding, informing ring manager...");

            String[] manager = managerInfo.split(":");

            channel = ManagedChannelBuilder
                    .forAddress(manager[0], Integer.parseInt(manager[1]))
                    .usePlaintext()
                    .build();

            registerServiceBlockingStub = RegisterServiceGrpc.newBlockingStub(channel);

            KvServerInfo nextKvServer = KvServerInfo.newBuilder()
                    .setServerIP(info[0])
                    .setServerPort(Integer.parseInt(info[1]))
                    .build();
            try {
                NextServer failReply = registerServiceBlockingStub.failInform(nextKvServer);

                nextServerInfo.setNextServer(failReply.getNextServerIP() + ":" + failReply.getNextServerPort());
                System.out.println("> new next server is: " + failReply.getNextServerIP() + ":" + failReply.getNextServerPort());

                // refazer o pedido para o novo nextServer
                channel = ManagedChannelBuilder
                        .forAddress(failReply.getNextServerIP(), failReply.getNextServerPort())
                        .usePlaintext()
                        .build();

                ringServiceBlockingStub = RingServiceGrpc.newBlockingStub(channel);

                WriteRequest writeRequest = WriteRequest.newBuilder()
                        .setKey(request.getKey())
                        .setValue(request.getValue())
                        .setOriginServer(myInfo)
                        .build();

                System.out.println("> sending writeNext to: " + failReply.getNextServerIP() + ":" + failReply.getNextServerPort());
                kvServerToKvServer.Reply replyNext = ringServiceBlockingStub.writeNext(writeRequest);
                System.out.println("> writeNext reply: " + replyNext.getReply());
            } catch (StatusRuntimeException e1) {
                System.out.println("> ring manager response: " + e1.getStatus().getDescription());
            }
        }
    }

    public void read(Key request, StreamObserver<Value> resSO) {
        System.out.println("> received read request from client");

        // tentar obter o valor V localmente
        String value = jedis.get(request.getKey());

        // se existir localmente, apenas enviar para o cliente o valor
        if (value != null) {
            System.out.println("> found the value locally");
            Value clientReply = Value.newBuilder().setValue(value).build();
            resSO.onNext(clientReply);
        }
        // se não existir localmente, propagar pedido
        else {
            System.out.println("> can't find the value locally");
            String[] info = nextServerInfo.getNextServer().split(":");

            try {
                // conectar ao próximo kvServer
                channel = ManagedChannelBuilder
                        .forAddress(info[0], Integer.parseInt(info[1]))
                        .usePlaintext()
                        .build();

                ringServiceBlockingStub = RingServiceGrpc.newBlockingStub(channel);

                // fazer pedido readNext
                ReadRequest readRequest = ReadRequest.newBuilder()
                        .setKey(request.getKey())
                        .setOriginServer(myInfo)
                        .build();

                System.out.println("> sending readNext to: " + info[0] + ":" + info[1]);
                Result readNextReply = ringServiceBlockingStub.readNext(readRequest);
                System.out.println("> readNext reply: " + readNextReply.getResult());

                // após obter resposta do anel enviar para o cliente
                Value clientReply = Value.newBuilder()
                        .setValue(readNextReply.getResult())
                        .build();

                resSO.onNext(clientReply);
            } catch (StatusRuntimeException e) {
                // failInform
                System.out.println("> " + info[0] + ":" + info[1] + " isn't responding, informing ring manager...");

                String[] manager = managerInfo.split(":");

                channel = ManagedChannelBuilder
                        .forAddress(manager[0], Integer.parseInt(manager[1]))
                        .usePlaintext()
                        .build();

                registerServiceBlockingStub = RegisterServiceGrpc.newBlockingStub(channel);

                KvServerInfo nextKvServer = KvServerInfo.newBuilder()
                        .setServerIP(info[0])
                        .setServerPort(Integer.parseInt(info[1]))
                        .build();

                try {
                    NextServer failReply = registerServiceBlockingStub.failInform(nextKvServer);
                    nextServerInfo.setNextServer(failReply.getNextServerIP() + ":" + failReply.getNextServerPort());
                    System.out.println("> new next server is: " + failReply.getNextServerIP() + ":" + failReply.getNextServerPort());

                    channel = ManagedChannelBuilder
                            .forAddress(failReply.getNextServerIP(), failReply.getNextServerPort())
                            .usePlaintext()
                            .build();

                    ringServiceBlockingStub = RingServiceGrpc.newBlockingStub(channel);

                    // fazer pedido readNext
                    ReadRequest readRequest = ReadRequest.newBuilder()
                            .setKey(request.getKey())
                            .setOriginServer(myInfo)
                            .build();

                    System.out.println("> sending readNext to: " + failReply.getNextServerIP() + ":" +  failReply.getNextServerPort());
                    Result readNextReply = ringServiceBlockingStub.readNext(readRequest);
                    System.out.println("> readNext reply: " + readNextReply.getResult());

                    // após obter resposta do anel enviar para o cliente
                    Value clientReply = Value.newBuilder()
                            .setValue(readNextReply.getResult())
                            .build();

                    resSO.onNext(clientReply);
                } catch (StatusRuntimeException e1) {
                    System.out.println("> ring manager response: " + e1.getStatus().getDescription());

                    Value clientReply = Value.newBuilder()
                            .setValue("no value found for key: " + request.getKey())
                            .build();
                    resSO.onNext(clientReply);
                }
            }
        }
        resSO.onCompleted();
        System.out.println("> sending read response to client");
    }

}
