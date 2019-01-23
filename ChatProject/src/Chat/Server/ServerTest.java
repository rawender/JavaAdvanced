package Chat.Server;

import Chat.Client.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerTest {
    private HashMap<String, ClientHandler> clients;

    public ServerTest(){
        clients = new HashMap <>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connect();
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this,socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void subscribe(String nick, ClientHandler client) {
        clients.put(nick, client);
    }

    public void unsubscribe(String nick) {
        clients.remove(nick);
    }

    public void broadcastMsg(ClientHandler sender, String msg) {
        for (ClientHandler o: clients.values()) {
            if (o == sender) {
                o.sendMsg(msg);
            } else {
                o.sendSignMsg(sender.getNick(), msg);
            }
        }
    }

    public boolean ifAccountVacant(String nick){
        for (String o: clients.keySet()) {
            if (o.equals(nick)) {
                return false;
            }
        }return true;
    }

    public void privMsg(ClientHandler sender, String nick, String msg) {
        if (notFind(nick)){
            sender.sendMsg("Пользователь отсутствует.");
        } else if (sender.getNick().equals(nick)) {
            sender.sendMsg("Невозможно выполнить.");
        } else {
            for (Map.Entry<String, ClientHandler> o: clients.entrySet()) {
                if (o.getKey().equals(nick)) {
                    o.getValue().sendPrivMsg(sender.getNick(), msg);
                }
            }
        }
    }

    private boolean notFind(String nick) {
        for (String o: clients.keySet()) {
            if (o.equals(nick)) {
                return false;
            }
        }return true;
    }
}
