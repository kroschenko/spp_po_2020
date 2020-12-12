package com.company;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Main extends JPanel {
    static int x = 10, y = 10, z = 600;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static JFrame frame;

    private static void addAndDrawLine(int param) {
        ArrayList sub = new ArrayList();
        if (list.size() == 0) {
            sub.add(x);
            sub.add(y);
        }
        x += (param - 1) % 2 * z;
        y += (param - 2) % 2 * z;
        if (list.size() != 0) {
            sub.add(list.get(list.size() - 1).get(2));
            sub.add(list.get(list.size() - 1).get(3));
        }
        sub.add(x);
        sub.add(y);
        list.add(sub);
        try {
            Thread.sleep(5);
        } catch (Exception e) {
        }
        frame.repaint();
    }

    private static void gilbert(int i, int j, int n) {
        if (n == 0) return;
        gilbert(j, i, n - 1);
        addAndDrawLine(j);
        gilbert(i, j, n - 1);
        addAndDrawLine(i);
        gilbert(i, j, n - 1);
        addAndDrawLine((j + 2) % 4);
        gilbert((j + 2) % 4, (i + 2) % 4, n - 1);
    }

    public static void main(String[] args) {
        int n;
        System.out.println("Введите порядок:");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        frame = new JFrame("Кривая Гильберта");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main panel = new Main();
        frame.add(panel);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        z /= ((1 << n) - 1);
        gilbert(2, 3, n);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(0, 0, 255));
        for (int i = 0; i < list.size(); i++) {
            g.drawLine(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3));
        }
    }
}
