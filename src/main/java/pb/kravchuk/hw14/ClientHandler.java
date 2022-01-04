package pb.kravchuk.hw14;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Server server;
    private PrintWriter outMsg;
    private Scanner inMsg;
    private static final String HOST = "localhost";
    private static final int PORT = 3221;
    private Socket clSocket = null;
    private static int clCount = 0;

    public ClientHandler(Socket clSocket, Server server) {
        try {
            clCount++;
            this.server = server;
            this.clSocket = clSocket;
            this.outMsg = new PrintWriter(clSocket.getOutputStream());
            this.inMsg = new Scanner(clSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                server.sendMessageToAll("New user entered");
                server.sendMessageToAll("Count of users: " + clCount);
                break;
            }

            while (true) {
                if (inMsg.hasNext()) {
                    String clMsg = inMsg.nextLine();
                    if (clMsg.equalsIgnoreCase("!exit!")) {
                        break;
                    }
                    System.out.println(clMsg);
                    server.sendMessageToAll(clMsg);
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
    }

    public void close() {
        server.removeClient(this);
        clCount--;
        server.sendMessageToAll("Count of users: " + clCount);
    }

    public void sendMsg(String msg) {
        try {
            outMsg.println(msg);
            outMsg.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
