package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class DrawPanel extends JPanel {

    private int iterations;

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
    public static int drawMinkowski(Graphics g, int iteration, Line obj, int length) {

        if (iteration == 0 || length == 0) {
            g.drawLine(obj.getX1(), obj.getY1(), obj.getX2(), obj.getY2());
            return 0;
        }

        Line arr[] = new Line[8];

        //Left-right
        if (obj.getY1() == obj.getY2() && obj.getX2() > obj.getX1()) {

            arr[0] = new Line(obj.getX1(), obj.getY1(), obj.getX1() + length, obj.getY1());
            arr[1] = new Line(obj.getX1() + length, obj.getY1(), obj.getX1() + length, obj.getY1() - length);
            arr[2] = new Line(obj.getX1() + length, obj.getY1() - length,
                    obj.getX1() + length * 2, obj.getY1() - length);
            arr[3] = new Line(obj.getX1() + length * 2, obj.getY1() - length, obj.getX1() + length * 2, obj.getY1());
            arr[4] = new Line(obj.getX1() + length * 2, obj.getY1(),
                    obj.getX1() + length * 2, obj.getY1() + length);
            arr[5] = new Line(obj.getX1() + length * 2, obj.getY1() + length, obj.getX1() + length * 3, obj.getY1() + length);
            arr[6] = new Line(obj.getX1() + length * 3, obj.getY1() + length, obj.getX1() + length * 3, obj.getY1());
            arr[7] = new Line(obj.getX1() + length * 3, obj.getY1(),
                    obj.getX2(), obj.getY1());
        }

        //Right-left
        if (obj.getY1() == obj.getY2() && obj.getX2() < obj.getX1()) {
            arr[0] = new Line(obj.getX1(), obj.getY1(), obj.getX1() - length, obj.getY1());
            arr[1] = new Line(obj.getX1() - length, obj.getY1(), obj.getX1() - length, obj.getY1() + length);
            arr[2] = new Line(obj.getX1() - length, obj.getY1() + length,
                    obj.getX1() - length * 2, obj.getY1() + length);
            arr[3] = new Line(obj.getX1() - length * 2, obj.getY1() + length, obj.getX1() - length * 2, obj.getY1());
            arr[4] = new Line(obj.getX1() - length * 2, obj.getY1(), obj.getX1() - length * 2, obj.getY1() - length);
            arr[5] = new Line(obj.getX1() - length * 2, obj.getY1() - length, obj.getX1() - length * 3, obj.getY1() - length);
            arr[6] = new Line(obj.getX1() - length * 3, obj.getY1() - length, obj.getX1() - length * 3, obj.getY1());
            arr[7] = new Line(obj.getX1() - length * 3, obj.getY1(), obj.getX2(), obj.getY1());
        }
            //Top-down
        if (obj.getX1() == obj.getX2() && obj.getY1() > obj.getY2()) {
            arr[0] = new Line(obj.getX1(), obj.getY1(), obj.getX1(), obj.getY1() - length);
            arr[1] = new Line(obj.getX1(), obj.getY1() - length, obj.getX1() - length, obj.getY1() - length);
            arr[2] = new Line(obj.getX1() - length, obj.getY1() - length, obj.getX1() - length, obj.getY1() - length * 2);
            arr[3] = new Line(obj.getX1() - length, obj.getY1() - length * 2, obj.getX1(), obj.getY1() - length * 2);
            arr[4] = new Line(obj.getX1(), obj.getY1() - length * 2, obj.getX1() + length, obj.getY1() - length * 2);
            arr[5] = new Line(obj.getX1() + length, obj.getY1() - length * 2, obj.getX1() + length, obj.getY1() - length * 3);
            arr[6] = new Line(obj.getX1() + length, obj.getY1() - length * 3, obj.getX1(), obj.getY1() - length * 3);
            arr[7] = new Line(obj.getX1(), obj.getY1() - length * 3, obj.getX2(), obj.getY2());
        }

        //Down-town
        if (obj.getX1() == obj.getX2() && obj.getY1() < obj.getY2()) {
            arr[0] = new Line(obj.getX1(), obj.getY1(), obj.getX1(), obj.getY1() + length);
            arr[1] = new Line(obj.getX1(), obj.getY1() + length, obj.getX1() + length, obj.getY1() + length);
            arr[2] = new Line(obj.getX1() + length, obj.getY1() + length, obj.getX1() + length, obj.getY1() + length * 2);
            arr[3] = new Line(obj.getX1() + length, obj.getY1() + length * 2, obj.getX1(), obj.getY1() + length * 2);
            arr[4] = new Line(obj.getX1(), obj.getY1() + length * 2, obj.getX1() - length, obj.getY1() + length * 2);
            arr[5] = new Line(obj.getX1() - length, obj.getY1() + length * 2, obj.getX1() - length, obj.getY1() + length * 3);
            arr[6] = new Line(obj.getX1() - length, obj.getY1() + length * 3, obj.getX1(), obj.getY1() + length * 3);
            arr[7] = new Line(obj.getX1(), obj.getY1() + length * 3, obj.getX2(), obj.getY2());
        }

        iteration--;
        length = length / 4;

        for (int i = 0; i < 8; i++) {
            drawMinkowski(g, iteration, arr[i], length);
        }
        return 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); this.setBackground(Color.black);
        g.setColor(Color.pink);
        Toolkit kit = Toolkit.getDefaultToolkit(); Dimension size = kit.getScreenSize();
        //Square side
        int length = 400;
        //Upper left angle
        int x1 = (int) size.getHeight() - length / 2 - 150;
        int y1 = 250;
        ArrayList<Line> arr = new ArrayList<Line>();
        Line one = new Line(x1, y1, x1 + length, y1);
        Line two = new Line(x1 + length, y1, x1 + length, y1 + length);
        Line three = new Line(x1 + length, y1 + length, x1, y1 + length);
        Line four = new Line(x1, y1 + length, x1, y1);
        arr.add(one);
        arr.add(two);
        arr.add(three);
        arr.add(four);
        drawMinkowski(g, iterations, one, length / 4);
        drawMinkowski(g, iterations, two, length / 4);
        drawMinkowski(g, iterations, three, length / 4);
        drawMinkowski(g, iterations, four, length / 4);
    }
}