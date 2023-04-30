package kvserver;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import kvServerToKvServer.*;
import kvServerToManager.KvServerInfo;
import kvServerToManager.NextServer;
import kvServerToManager.RegisterServiceGrpc;
import redis.clients.jedis.Jedis;

public class RingServiceImpl extends RingServiceGrpc.RingServiceImplBase {

    private final Jedis jedis;
    private final NextServerInfo nextServerInfo;
    private final String myInfo;
    private final String managerInfo;

    private static RingServiceGrpc.RingServiceBlockingStub ringServiceBlockingStub;
    private static RegisterServiceGrpc.RegisterServiceBlockingStub registerServiceBlockingStub;

    private static ManagedChannel channel;
    public RingServiceImpl(Jedis jedis, String managerInfo, String myInfo, NextServerInfo nextServerInfo) {
        this.nextServerInfo = nextServerInfo;
        this.jedis = jedis;
        this.myInfo = myInfo;
        this.managerInfo = managerInfo;
    }

    public void writeNext(WriteRequest request, StreamObserver<Reply> resSO) {
        System.out.println("> received write request from ring");

        String[] info = nextServerInfo.getNextServer().split(":");

        // verificar se o kvServer atual não começou o pedido no anel
        if (!request.getOriginServer().equals(myInfo)) {

            // escrever par KV localmente
            jedis.set(request.getKey(), request.getValue());

            // informar servidor anterior da escrita local
            Reply reply = Reply.newBuilder().setReply("writeNext successful!").build();
            resSO.onNext(reply);
            resSO.onCompleted();

            // propagar para o próximo servidor
            try {
                channel = ManagedChannelBuilder
                        .forAddress(info[0], Integer.parseInt(info[1]))
                        .usePlaintext()
                        .build();

                ringServiceBlockingStub = RingServiceGrpc.newBlockingStub(channel);

                System.out.println("> sending writeNext to: " + info[0] + ":" + info[1]);
                Reply replyNext = ringServiceBlockingStub.writeNext(request);
                System.out.println("> writeNext reply: " + replyNext.getReply());
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

                NextServer failReply = registerServiceBlockingStub.failInform(nextKvServer);

                nextServerInfo.setNextServer(failReply.getNextServerIP() + ":" + failReply.getNextServerPort());
                System.out.println("> new next server is: " + failReply.getNextServerIP() + ":" + failReply.getNextServerPort());

                channel = ManagedChannelBuilder
                        .forAddress(failReply.getNextServerIP(), failReply.getNextServerPort())
                        .usePlaintext()
                        .build();

                ringServiceBlockingStub = RingServiceGrpc.newBlockingStub(channel);

                channel = ManagedChannelBuilder
                        .forAddress(failReply.getNextServerIP(), failReply.getNextServerPort())
                        .usePlaintext()
                        .build();

                ringServiceBlockingStub = RingServiceGrpc.newBlockingStub(channel);

                System.out.println("> sending writeNext to: " + failReply.getNextServerIP() + ":" + failReply.getNextServerPort());
                Reply replyNext = ringServiceBlockingStub.writeNext(request);
                System.out.println("> writeNext reply: " + replyNext.getReply());
            }

        }
        else {
            System.out.println("> end of writeNext");
            Reply reply = Reply.newBuilder().setReply("writeNext reached original server").build();
            resSO.onNext(reply);
            resSO.onCompleted();
        }

    }

    public void readNext(ReadRequest request, StreamObserver<Result> resSO) {
        System.out.println("> received read request from ring");

        // verificar se o kvServer atual não começou o pedido no anel
        if (!request.getOriginServer().equals(myInfo)) {

            // verificar se o valor existe localmente
            String value = jedis.get(request.getKey());

            // se o valor existir localmente enviar para o servidor anterior
            if (value != null) {
                Result result = Result.newBuilder()
                        .setResult(value)
                        .build();

                resSO.onNext(result);
                resSO.onCompleted();

                System.out.println("> found the value locally, sending readNext result to previous KvServer");
            }
            // se o valor não existir localmente
            else {
                String[] info = nextServerInfo.getNextServer().split(":");
                try {
                    // conectar ao próximo kvServer
                    channel = ManagedChannelBuilder
                            .forAddress(info[0], Integer.parseInt(info[1]))
                            .usePlaintext()
                            .build();

                    ringServiceBlockingStub = RingServiceGrpc.newBlockingStub(channel);

                    // enviar readNext com o pedido original
                    System.out.println("> can't find the value locally, sending readNext to " + info[0] + ":" + info[1]);
                    Result readNextResult = ringServiceBlockingStub.readNext(request);
                    System.out.println("> readNext response from " + info[0] + ":" + info[1] + ": " + readNextResult.getResult());

                    // enviar resposta do readNext ao kvServer anterior
                    resSO.onNext(readNextResult);
                    resSO.onCompleted();
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

                    NextServer failReply = registerServiceBlockingStub.failInform(nextKvServer);

                    nextServerInfo.setNextServer(failReply.getNextServerIP() + ":" + failReply.getNextServerPort());
                    System.out.println("> new next server is: " + failReply.getNextServerIP() + ":" + failReply.getNextServerPort());

                    // conectar ao próximo kvServer
                    channel = ManagedChannelBuilder
                            .forAddress(failReply.getNextServerIP(), failReply.getNextServerPort())
                            .usePlaintext()
                            .build();

                    ringServiceBlockingStub = RingServiceGrpc.newBlockingStub(channel);

                    // enviar readNext com o pedido original
                    System.out.println("> sending readNext to " + failReply.getNextServerIP() + ":" + failReply.getNextServerPort());
                    Result readNextResult = ringServiceBlockingStub.readNext(request);
                    System.out.println("> readNext response from " +failReply.getNextServerIP() + ":" + failReply.getNextServerPort() + ": " + readNextResult.getResult());

                    // enviar resposta do readNext ao kvServer anterior
                    resSO.onNext(readNextResult);
                    resSO.onCompleted();
                }
            }
        } else {
            System.out.println("> readNext reached original server");
            Result readNextResult = Result.newBuilder()
                    .setResult("no value found for key: " + request.getKey())
                    .build();
            resSO.onNext(readNextResult);
            resSO.onCompleted();
        }
    }

}
