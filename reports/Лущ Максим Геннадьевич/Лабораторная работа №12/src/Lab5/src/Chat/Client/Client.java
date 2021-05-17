package Chat.Client;

import Chat.Models.Answer;

import java.net.*;
import java.io.*;

public class Client {
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Socket socket;

    private final ClientGUI client;
    private final String server;
    private final String username;
    private final int port;

    Client(String server, int port, String username, ClientGUI client) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.client = client;
    }

    public boolean start() {
        try {
            socket = new Socket(server, port);
        } catch (Exception ec) {
            display("Error connecting to server:" + ec);
            return false;
        }
        String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
        display(msg);

        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException eIO) {
            display("Exception creating new Input/output Streams: " + eIO);
            return false;
        }

        new ListenFromServer().start();
        try {
            outputStream.writeObject(username);
        } catch (IOException eIO) {
            display("Exception doing login : " + eIO);
            disconnect();
            return false;
        }

        return true;
    }

    private void display(String msg) {
        client.append(msg + "\n");
    }

    void sendMessage(Answer msg) {
        try {
            outputStream.writeObject(msg);
        } catch (IOException e) {
            display("Exception writing to server: " + e);
        }
    }

    private void disconnect() {
        try {
            if (inputStream != null)
                inputStream.close();

            if (outputStream != null)
                outputStream.close();

            if (socket != null)
                socket.close();
        } catch (Exception ignored) {
        }

        if (client != null)
            client.connectionFailed();
    }

    class ListenFromServer extends Thread {
        public void run() {
            while (true) {
                try {
                    String msg = (String) inputStream.readObject();
                    if (client == null) {
                        System.out.println(msg);
                        System.out.print("> ");
                    } else {
                        client.append(msg);
                    }
                } catch (IOException e) {
                    display("Server has close the connection: " + e);
                    if (client != null)
                        client.connectionFailed();
                    break;
                } catch (ClassNotFoundException ignored) {
                }
            }
        }
    }
}
