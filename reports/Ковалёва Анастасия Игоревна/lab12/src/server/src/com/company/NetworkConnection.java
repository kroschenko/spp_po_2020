package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class NetworkConnection {

    ServerSocket serverSocket;

    int PORT = 55555;

    List<Socket> users = new LinkedList<>();

    public NetworkConnection(){
        try {
                serverSocket = new ServerSocket(PORT, 2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket setUsers(){
        Socket s = null;
                try {
                     s = serverSocket.accept();
                     users.add(s);
                    DataOutputStream out = new DataOutputStream(s.getOutputStream());
                    out.writeUTF(String.valueOf(users.indexOf(s)));
                    out.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return s;
    }

    public String getCommand(int user){
        String command = null;
        try {
            DataInputStream in = new DataInputStream(users.get(user).getInputStream());
            command = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return command;
    }

    public int getStep(int user){
        int command = 0;
        try {
            DataInputStream in = new DataInputStream(users.get(user).getInputStream());
            command = Integer.parseInt(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return command;
    }

    public void sendMessage(String message, int user){
        try {
            DataOutputStream out = new DataOutputStream(users.get(user).getOutputStream());
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean areTwoPlayers(){
        return users.size() == 2;
    }

    public void sendMessageForAll(String message) {
        for (Socket soket : users) {
            DataOutputStream out = null;
            try {
                out = new DataOutputStream(soket.getOutputStream());

                out.writeUTF(String.valueOf(message));
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
