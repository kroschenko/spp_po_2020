package com.company;
import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {
    static int iA, jA;
    static int iN, jN;
    static int iA2, jA2;
    static int iS, jS;
    static int iT, jT;
    static int iA3, jA3;
    static int iS2, jS2;
    static int iI, jI;
    static int iA4, jA4;
    static int i0, j0;
    static JFrame frame = new JFrame("Строка");

    public static void init() {
        iA = -400; jA = -50;
        iN = -350; jN = 850;
        iA2 = 600;  jA2 = 850;
        iS = 650; jS = -50;
        iT = -200; jT = -50;
        iA3 = -150; jA3 = 850;
        iS2 = 810; jS2 = 850;
        iI = 860; jI = -50;
        iA4 = 0; jA4 = -50;
        i0 = 50; j0 = 850;
    }

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main panel = new Main();
        frame.add(panel);
        frame.setMinimumSize(new Dimension(700, 700));
        frame.setVisible(true);
        while (true) {
            init();
            while (jA != 400) {
                iA++;
                jA++;
                frame.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            while (jN != 400) {
                iN++;
                jN--;
                frame.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            while (jA2 != 400) {
                iA2--;
                jA2--;
                frame.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            while (jS != 400) {
                iS--;
                jS++;
                frame.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            while (jT != 400) {
                iT++;
                jT++;
                frame.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            while (jA3 != 400) {
                iA3++;
                jA3--;
                frame.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            while (jS2 != 400) {
                iS2--;
                jS2--;
                frame.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            while (jI != 400) {
                iI--;
                jI++;
                frame.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            while (jA4 != 400) {
                iA4++;
                jA4++;
                frame.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            while (j0 != 400) {
                i0++;
                j0--;
                frame.repaint();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(241, 245, 164));
        g.fillRect(0, 0, 700, 700);
        g.setFont(new Font("Impact", Font.PLAIN, 70));
        g.setColor(new Color(142, 255, 81));
        g.drawString("A", iA, jA);
        g.drawString("N", iN, jN);
        g.drawString("A", iA2, jA2);
        g.drawString("S", iS, jS);
        g.drawString("T", iT, jT);
        g.drawString("A", iA3, jA3);
        g.drawString("S", iS2, jS2);
        g.drawString("I", iI, jI);
        g.drawString("A", iA4, jA4);
        g.drawString("!", i0, j0);
    }
}
