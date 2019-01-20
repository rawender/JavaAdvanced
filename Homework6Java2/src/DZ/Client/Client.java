package DZ.Client;

import java.io.*;
import java.net.Socket;

public class Client {
    static Socket server;
    static BufferedReader in;
    static PrintWriter out;
    private static String IP_ADRESS = "localHost";
    private static int PORT = 7189;

    public static void main(String[] args) {

        try {
            server = new Socket(IP_ADRESS, PORT);

            out = new PrintWriter(server.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String msg;


            while ((msg = stdIn.readLine()) != null) {
                out.println(msg);
                String str = in.readLine();
                System.out.println("Server: " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
