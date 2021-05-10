package com.company;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        NetworkConnection nc = new NetworkConnection();

        while (!nc.areTwoPlayers()){
           Socket s = nc.setUsers();
            System.out.println("Player " + (nc.users.indexOf(s)+1) + " connected");
        }

        startNewGame(nc);

    }

    public static void startNewGame(NetworkConnection nc){
        System.out.println("Start game");
        int score = 0;

        while (true){
            String str = nc.getCommand(0);
            score = Integer.parseInt(str);
            if(score <= 0) {
                System.out.println("Win player one");
                nc.sendMessage("Win player one", 1);
                break;
            }
            nc.sendMessage(str, 1);
            String str1 = nc.getCommand(1);
            score = Integer.parseInt(str1);
            if(score <= 0) {
                System.out.println("Win player two");
                nc.sendMessage("Win player two", 0);
                break;
            }
            System.out.println(str1);
            nc.sendMessage(str1, 0);
        }
    }
}