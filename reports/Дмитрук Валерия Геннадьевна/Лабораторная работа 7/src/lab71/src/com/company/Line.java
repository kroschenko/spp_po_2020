package com.company;

import java.awt.*;
public class Line {
    private int k, b;
    private int x1, x2, y1, y2;
    public Line(int k, int b, int x1, int x2) {
        this.k = k;
        this.b = b;
        this.x1 = x1;
        this.y1 = k * x1 + b; this.x2 = x2;
        this.y2 = k * x2 + b;
    }
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GRAY);
        g.drawLine(x1, y1, x2, y2);
    }
    public int getK() {
        return k;
    }
    public void setK(int k) {
        this.k = k;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
}
