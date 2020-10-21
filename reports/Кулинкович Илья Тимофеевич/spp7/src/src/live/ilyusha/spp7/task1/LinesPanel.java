package live.ilyusha.spp7.task1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class LinesPanel extends JPanel {

    ArrayList<Line> lines;

    public LinesPanel(ArrayList<Line> lines) {
        super();
        this.lines = lines;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setColor(Color.blue);
        for (Line l: lines) {
            g.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
        }
    }

}
