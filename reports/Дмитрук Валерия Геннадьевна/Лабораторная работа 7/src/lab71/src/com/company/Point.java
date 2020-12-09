package com.company;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Point {
    private int x, y;
    private static int width = 10, height = 10;
    private Color color;
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) { this.color = color;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.GRAY;
    }
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double point = new Ellipse2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(point); }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}