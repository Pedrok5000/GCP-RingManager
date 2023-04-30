package ringmanager;

import io.grpc.ServerBuilder;

public class RingManagerServer {

    private static final int MANAGER_PORT = 8000;
    private static final int NUMBER_OF_KVSERVERS = 3;

    public static void main(String[] args) {

        RingInfo ringInfo = new RingInfo(NUMBER_OF_KVSERVERS);

        try {
            io.grpc.Server server = ServerBuilder.forPort(MANAGER_PORT)
                    .addService(new RegisterServiceImpl(ringInfo))
                    .addService(new GetServerServiceImpl(ringInfo))
                    .build();

            server.start();
            System.out.println("> ring manager running on port: " + MANAGER_PORT);
            server.awaitTermination();
        }
        catch (Exception e) {
            System.out.println("> " + e);
        }
    }
}
