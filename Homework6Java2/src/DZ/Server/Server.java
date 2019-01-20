package DZ.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(7189);
            System.out.println("Сервер запущен!");

            client = server.accept();
            System.out.println("Клиент подключился.");

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String msg;

            while ((msg = in.readLine()) != null) {
                System.out.println("Client: " + msg);
                out.println("OK");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


