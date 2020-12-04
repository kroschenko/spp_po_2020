package com.company;

import javax.swing.*; import java.awt.*;
import java.util.ArrayList; import java.util.List;
import java.util.Random; import java.util.Scanner;
public class Main extends JPanel { static final int BORDER = 390;
    private List<Point> points = new ArrayList<>(); private Line line;
    private Random random = new Random();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Points and Line");
        frame.add(new Main(10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public Main(int i) { setBackground(Color.BLACK); setPreferredSize(new Dimension(400, 400));
        for (int j = 0; j < i; j++) {
            addCircle(BORDER, BORDER);
        }
        addLine();
    }

    public void addCircle(int maxX, int maxY) {
        points.add(new Point(random.nextInt(maxX), random.nextInt(maxY)));
        repaint();
    }
    public void addLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter k and b, x1 and x2: ");
        this.line = new Line(
                scanner.nextInt(), scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt()
        );
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) { super.paintComponent(g);
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            int currentY = line.getK() * point.getX() + line.getB(); if (currentY < point.getY()) {
                point.setColor(Color.YELLOW);
            } else if (currentY > point.getY()) {
                point.setColor(Color.BLUE); }
            point.draw(g); }
        this.line.draw(g); }
}