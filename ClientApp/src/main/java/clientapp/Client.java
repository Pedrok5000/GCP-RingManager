package clientapp;

import clientToKvServer.*;
import clientToManager.GetServerServiceGrpc;
import clientToManager.ServerInfo;
import clientToManager.Void;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;
import java.util.Scanner;

public class Client {

    private static String MANAGER_IP;
    private static final int MANAGER_PORT = 8000;

    // stubs
    private static GetServerServiceGrpc.GetServerServiceBlockingStub getServerServiceBlockingStub;
    private static BaseServiceGrpc.BaseServiceBlockingStub baseServiceBlockingStub;

    private static ManagedChannel channel;

    private static final String HASH_FUNCTION = "SHA-256";

    private static int Menu() {
        int op;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("#### MENU ####");
            System.out.println(" 1 - Write KeyValue Pair");
            System.out.println(" 2 - Read Value");
            System.out.println("99 - Exit");
            System.out.println();
            System.out.print("> ");
            op = scan.nextInt();
        } while (!((op >= 1 && op <= 2) || op == 99));
        return op;
    }

    static String getServerRequest() {
        System.out.println("> sending get server request to: " + MANAGER_IP + ":" + MANAGER_PORT);
        clientToManager.Void request = Void.newBuilder().build();
        try {
            ServerInfo reply = getServerServiceBlockingStub.getKvServer(request);
            String server = reply.getServerIP() + ":" + reply.getServerPort();
            System.out.println("> ring manager reply: " + server);
            return server;
        }
        catch (StatusRuntimeException e) {
            return e.getMessage();
        }
    }

    static void writeRequest(String kvServerIP, int kvServerPort) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("> enter the value name: ");
        String valueName = scanner.next();

        System.out.print("> enter the value: ");
        String value = scanner.next();

        String jsonValue = "{" + "\n" + "\t" + "\"" + valueName + "\""+ ":" + value + "\n" + "}";

        try {
            // gerar string aleatória
            byte[] array = new byte[10];
            new Random().nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);

            // gerar key (hash da string anterior)
            MessageDigest funcDigest = MessageDigest.getInstance(HASH_FUNCTION);
            byte[] arr = funcDigest.digest(generatedString.getBytes());
            String key = Base64.getEncoder().withoutPadding().encodeToString(arr);

            System.out.println("> generated key for: " + "\n" + jsonValue + "\n" + "is " + key + "\n");

            KeyValue request = KeyValue.newBuilder()
                    .setKey(key)
                    .setValue(jsonValue)
                    .build();

            System.out.println("> sending write request to: " + kvServerIP + ":" + kvServerPort);
            Reply reply = baseServiceBlockingStub.writeUpdate(request);
            System.out.println("> reply from " + kvServerIP + ":" + kvServerPort + ": " + reply.getReply());
        }
        catch (StatusRuntimeException e) {
            System.out.println("> " + kvServerIP + ":" + kvServerPort + " is down, reconnect to another server");
            System.exit(-1);
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("> " + e);
            System.exit(-1);
        }

    }

    static void readRequest(String kvServerIP, int kvServerPort) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("> enter the key");
        System.out.print("> ");

        Key key = Key.newBuilder()
                .setKey(scanner.next())
                .build();

        try {
            System.out.println("> sending read request to: " + kvServerIP + ":" + kvServerPort);
            Value reply = baseServiceBlockingStub.read(key);
            System.out.println("> read response:" + "\n" + reply.getValue());
        }
        catch (Exception e) {
            System.out.println("> " + kvServerIP + ":" + kvServerPort + " is down, reconnect to another server");
            System.exit(-1);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        if (args.length == 1) {
            MANAGER_IP = args[0];
        } else {
            System.out.println("Usage: RingManagerIP");
            System.exit(-1);
        }
        System.out.println("> connecting to ring manager at " + MANAGER_IP + ":" + MANAGER_PORT);
        channel = ManagedChannelBuilder.forAddress(MANAGER_IP, MANAGER_PORT)
                .usePlaintext()
                .build();

        getServerServiceBlockingStub = GetServerServiceGrpc.newBlockingStub(channel);

        String kvServer = getServerRequest();

        // se o manager nao estiver online
        if (kvServer.equals("UNAVAILABLE: io exception")) {
            System.out.println("> can't reach " + MANAGER_IP + ":" + MANAGER_PORT + ", exiting app...");
            System.exit(-1);
        }

        // tentar até o anel estiver completo
        while (kvServer.equals("UNAVAILABLE")) {
            System.out.println("> the ring hasn't formed yet, try again later");
            Thread.sleep(10 * 1000);
            kvServer = getServerRequest();
        }

        String[] kvServerInfo = kvServer.split(":");
        String kvServerIP = kvServerInfo[0];
        int kvServerPort = Integer.parseInt(kvServerInfo[1]);

        System.out.println("> disconnecting from " + MANAGER_IP + ":" + MANAGER_PORT);

        System.out.println("> connecting to " + kvServerIP + ":" + kvServerPort);
        channel = ManagedChannelBuilder.forAddress(kvServerIP, kvServerPort)
                .usePlaintext()
                .build();

        baseServiceBlockingStub = BaseServiceGrpc.newBlockingStub(channel);

        boolean endMenu = false;
        while (!endMenu) {
            int option = Menu();
            switch (option) {
                case 1:
                    writeRequest(kvServerIP, kvServerPort);
                    break;
                case 2:
                    readRequest(kvServerIP, kvServerPort);
                    break;
                case 99:
                    endMenu = true;
                    break;
            }
        }
    }

}
