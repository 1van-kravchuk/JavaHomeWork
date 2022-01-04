package pb.kravchuk.hw14;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static final int PORT = 3221;
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    public Server() {
        Socket clSocket = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started");
            while (true) {
                clSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clSocket, this);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clSocket.close();
                System.out.println("Server stopped");
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessageToAll(String msg) {
        for (ClientHandler cl :
                clients) {
            cl.sendMsg(msg);
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}
