package live.ilyusha.spp7.task2;

import javax.swing.*;
import java.awt.*;

public class LevyPanel extends JPanel {

    private final int iterations;
    private final Color color;

    LevyPanel(int n, Color col) {
        iterations = n;
        color = col;
    }

    public void paintComponent(Graphics g){
        super.paintComponents(g);
        drawLevy(150, 350, 450, 350, iterations, color, g);
    }

    private void drawLevy(int x1, int y1, int x2, int y2, int n, Color color, Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setColor(color);

        if (n == 0) {
            g.drawLine(x1, y1, x2, y2);
            return;
        }

        int x = (x1 + x2) / 2 + (y2 - y1) / 2;
        int y = (y1 + y2) / 2 - (x2 - x1) / 2;
        drawLevy(x1, y1, x,  y,  n - 1, color, g);
        drawLevy(x,  y,  x2, y2, n - 1, color, g);
    }

}

