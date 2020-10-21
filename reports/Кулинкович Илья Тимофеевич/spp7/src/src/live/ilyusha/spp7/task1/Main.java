package live.ilyusha.spp7.task1;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Line> lines = new ArrayList<Line>();
        ArrayList<Line> intersectingLines = new ArrayList<Line>();


        lines.add(new Line(25,25,275,275));
        lines.add(new Line(50, 100, 200, 250));
        lines.add(new Line(75, 100, 150, 25));
        lines.add(new Line(100,25,300,225));
        lines.add(new Line(250,25,200,110));
        lines.add(new Line(200,225,300,175));

        for (Line i: lines) {
            for (Line j : lines) {
                if (i.intersects(j)) {
                    intersectingLines.add(i);
                    intersectingLines.add(j);
                }
            }
        }

        for (Line i: lines) {
            for (Line j : lines) {
                if (i.equals(j)) intersectingLines.remove(j);
            }
        }

        JFrame window = new JFrame();
        window.setSize(350, 350);

        LinesPanel linesPanel = new LinesPanel(intersectingLines);

        window.add(linesPanel);
        window.setVisible(true);
    }

}
