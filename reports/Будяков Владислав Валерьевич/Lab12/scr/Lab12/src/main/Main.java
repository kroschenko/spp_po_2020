package main;
import java.net.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8000); while (true) {
            Socket clientSocket = socket.accept();
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            int maxCount = 3; writer.write(String.valueOf(maxCount)); writer.flush();
            writer.close();
            System.out.println("Client connected!"); clientSocket.close();
        } }
}