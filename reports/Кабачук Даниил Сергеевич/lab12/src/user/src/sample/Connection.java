package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {

    String URL = "localhost";
    int PORT = 55555;
    Socket socket;
    DataOutputStream out;
    DataInputStream in;

    public Connection() {
        try {
            socket = new Socket(URL, PORT);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMessage() {
        String temp = null;
        try {
            temp = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
