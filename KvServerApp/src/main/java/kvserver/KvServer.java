package kvserver;

import io.grpc.*;
import kvServerToManager.KvServerInfo;
import kvServerToManager.NextServer;
import kvServerToManager.RegisterServiceGrpc;
import kvServerToManager.Reply;
import redis.clients.jedis.Jedis;

public class KvServer {

    //params do kvServer
    private static String SERVER_IP;
    private static int SERVER_PORT;

    //params do ringManager
    private static String MANAGER_IP;
    private static final int MANAGER_PORT = 8000;

    //params do servidor redis
    private static final String REDIS_IP = "localhost";
    private static int REDIS_PORT;

    private static ManagedChannel channel;
    private static RegisterServiceGrpc.RegisterServiceBlockingStub registerServiceBlockingStub;

    public static NextServerInfo nextServerInfo;

    static boolean registerRequest() {
        System.out.println("> sending register request to: " + MANAGER_IP);
        KvServerInfo request = KvServerInfo.newBuilder()
                .setServerIP(SERVER_IP)
                .setServerPort(SERVER_PORT)
                .build();
        try {
            Reply reply = registerServiceBlockingStub.registerServer(request);
            System.out.println("> ring manager reply: " + reply.getReply());
            return true;
        }
        catch (StatusRuntimeException e) {
            System.out.println("> ring manager reply: " + e.getMessage());
            return false;
        }
    }

    static boolean getNextServerRequest() {
        System.out.println("> sending get next server request to: " + MANAGER_IP + ":" + MANAGER_PORT);
        KvServerInfo request = KvServerInfo.newBuilder()
                .setServerIP(SERVER_IP)
                .setServerPort(SERVER_PORT)
                .build();

        try {
            NextServer reply = registerServiceBlockingStub.getNextServer(request);
            System.out.println("> ring manager reply: Your next server is: "
                    + reply.getNextServerIP() + ":" + reply.getNextServerPort());

            nextServerInfo.setNextServer(reply.getNextServerIP() + ":" + reply.getNextServerPort());
            return true;
        }
        catch (StatusRuntimeException e) {
            System.out.println("> ring manager reply: " + e.getMessage());
            return e.getStatus().equals(Status.PERMISSION_DENIED);
        }
    }

    public static void main(String[] args) {

        try {
            if (args.length == 4) {
                SERVER_IP = args[0];
                SERVER_PORT = Integer.parseInt(args[1]);
                MANAGER_IP = args[2];
                REDIS_PORT = Integer.parseInt(args[3]);

                Jedis jedis = new Jedis(REDIS_IP, REDIS_PORT);

                System.out.println("> redis is running on " + REDIS_IP + ":" + REDIS_PORT + " " + jedis.ping());

                // o nextServer é atualizado na chamada da operação getNextServerRequest()
                nextServerInfo = new NextServerInfo("tmp");

                String myInfo = SERVER_IP + ":" + SERVER_PORT;

                String managerInfo = MANAGER_IP + ":" + MANAGER_PORT;

                io.grpc.Server server = ServerBuilder.forPort(SERVER_PORT)
                        .addService(new BaseServiceImpl(jedis, managerInfo, myInfo, nextServerInfo))
                        .addService(new RingServiceImpl(jedis, managerInfo, myInfo, nextServerInfo))
                        .build();

                // iniciar kvServer
                server.start();
                System.out.println("> kvServer running on port " + SERVER_PORT);

                // conectar ao ringManager
                System.out.println("> connecting to: " + MANAGER_IP + ":" + MANAGER_PORT);
                channel = ManagedChannelBuilder.forAddress(MANAGER_IP, MANAGER_PORT)
                        .usePlaintext()
                        .build();

                registerServiceBlockingStub = RegisterServiceGrpc.newBlockingStub(channel);

                // se o anel ja se encontrar completo terminar aplicação
                if (! registerRequest()) System.exit(-1);

                // se o anel ainda não estiver completo, esperar e enviar novo pedido
                while (! getNextServerRequest())
                    Thread.sleep(10*1000);

                server.awaitTermination();
            } else {
                System.out.println("Usage: kvServerIP kvServerPort RingManagerIP RedisPort");
                System.exit(-1);
            }
        }
        catch (Exception e) {
            System.out.println("> exception occurred: " + e);
        }
    }

}
