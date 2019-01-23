package Chat.Client;

import Chat.Server.AuthService;
import Chat.Server.ServerTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private ServerTest server;
    private String nick;

    public ClientHandler(ServerTest server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();

                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickLoginAndPass(tokens[1], tokens[2]);
                                if (newNick != null) {
                                    if (server.ifAccountVacant(newNick)) {
                                        sendMsg("/authok");
                                        nick = newNick;
                                        server.subscribe(nick, ClientHandler.this);
                                        sendMsg("Вы вошли в чат!");
                                        break;
                                    } else {
                                        sendMsg("Аккаунт уже используется!");
                                    }
                                } else {
                                    sendMsg("Неверный логин/пароль!");
                                }
                            }
                        }

                        while (true) {
                            String str = in.readUTF();
                            if(str.equals("/end")) {
                                out.writeUTF("/serverClosed");
                                break;
                            }
                            if(str.startsWith("/w ")) {
                                String[] tokens = str.split(" ", 3);
                                String privNick = tokens[1];
                                String msg = tokens[2];
                                server.privMsg(ClientHandler.this, privNick, msg);
                            } else {
                                server.broadcastMsg(ClientHandler.this, str);
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(nick);
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendSignMsg(String nickname, String msg) {
        try {
            out.writeUTF(nickname + ": " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPrivMsg(String nickname, String msg) {
        try {
            out.writeUTF(nickname + " шепчет: " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
