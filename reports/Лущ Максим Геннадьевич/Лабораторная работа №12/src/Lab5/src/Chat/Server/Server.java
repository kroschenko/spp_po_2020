package Chat.Server;

import Chat.Models.Answer;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Server {
    private static int uniqueId;
    private final ArrayList<ClientThread> al;
    private final ServerGUI sg;
    private final SimpleDateFormat sdf;
    private final int port;
    private boolean keepGoing;

    public Server(int port, ServerGUI sg) {
        this.sg = sg;
        this.port = port;
        sdf = new SimpleDateFormat("HH:mm:ss");
        al = new ArrayList<>();
    }

    public void start() {
        keepGoing = true;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (keepGoing) {
                display("Server waiting for Clients on port " + port + ".");
                Socket socket = serverSocket.accept();
                if (!keepGoing)
                    break;
                ClientThread t = new ClientThread(socket);
                al.add(t);
                t.start();
            }

            try {
                serverSocket.close();
                for (ClientThread tc : al) {
                    try {
                        tc.sInput.close();
                        tc.sOutput.close();
                        tc.socket.close();
                    } catch (IOException ignored) {
                    }
                }
            } catch (Exception e) {
                display("Exception closing the server and clients: " + e);
            }
        } catch (IOException e) {
            String msg = sdf.format(new Date()) + " Exception on new ServerSocket: "
                    + e + "\n";
            display(msg);
        }
    }

    protected void stop() {
        keepGoing = false;
        try {
            new Socket("localhost", port);
        } catch (Exception ignored) {
        }
    }

    private void display(String msg) {
        String time = sdf.format(new Date()) + " " + msg;
        sg.appendEvent(time + "\n");
    }

    private synchronized void broadcast(String message) {
        String time = sdf.format(new Date());
        String messageLf = time + " " + message + "\n";
        if (sg == null)
            System.out.print(messageLf);
        else
            sg.appendRoom(messageLf);

        for (int i = al.size(); --i >= 0; ) {
            ClientThread ct = al.get(i);
            if (!ct.writeMsg(messageLf)) {
                al.remove(i);
                display("Disconnected Client " + ct.username + " removed from list.");
            }
        }
    }

    synchronized void remove(int id) {
        for (int i = 0; i < al.size(); ++i) {
            ClientThread ct = al.get(i);
            if (ct.id == id) {
                al.remove(i);
                return;
            }
        }
    }

    class ClientThread extends Thread {
        Socket socket;
        ObjectInputStream sInput;
        ObjectOutputStream sOutput;

        int id;
        String username;
        Answer cm;
        String date;

        ClientThread(Socket socket) {
            id = ++uniqueId;
            this.socket = socket;
            System.out.println("Thread trying to create Object Input/Output Streams");
            try {
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput = new ObjectInputStream(socket.getInputStream());
                username = (String) sInput.readObject();
                display(username + " just connected.");
            } catch (IOException e) {
                display("Exception creating new Input/output Streams: " + e);
                return;
            } catch (ClassNotFoundException ignored) {
            }
            date = new Date().toString() + "\n";
        }

        public void run() {
            boolean keepGoing = true;
            while (keepGoing) {
                try {
                    cm = (Answer) sInput.readObject();
                } catch (IOException e) {
                    display(username + " Exception reading Streams: " + e);
                    break;
                } catch (ClassNotFoundException e2) {
                    break;
                }

                String message = cm.getMessage();
                switch (cm.getType()) {
                    case Answer -> broadcast(username + ": " + message);
                    case Logout -> {
                        display(username + " disconnected with a LOGOUT message.");
                        keepGoing = false;
                    }
                }
            }
            remove(id);
            close();
        }

        private void close() {
            try {
                if (sOutput != null) sOutput.close();
                if (sInput != null) sInput.close();
                if (socket != null) socket.close();
            } catch (Exception e) {
                display("Exception while close: " + e);
            }
        }

        private boolean writeMsg(String msg) {
            if (!socket.isConnected()) {
                close();
                return false;
            }
            try {
                sOutput.writeObject(msg);
            } catch (IOException e) {
                display("Error sending message to " + username);
                display(e.toString());
            }
            return true;
        }
    }
}