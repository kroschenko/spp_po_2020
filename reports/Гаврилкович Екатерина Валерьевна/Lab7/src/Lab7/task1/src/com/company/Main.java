import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JPanel {
    private final static int AMT_OF_LINES = 10;
    private final static int WIDTH = 613;
    private final static int HEIGHT = 550;
    private Line[] lines;
    private Main() {
        Random random = new Random();
        lines = new Line[AMT_OF_LINES];
        for (int i = 0; i < AMT_OF_LINES; i++) {
            lines[i] = new Line(random.nextInt(WIDTH), random.nextInt(HEIGHT),
                    random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
    }
    public void paintComponent(Graphics graphics) {
        for (Line line : lines) {
            if (checkIfCross(line)) {
                graphics.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cross Lines");
        Main panel = new Main();
        frame.add(panel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private boolean checkIfCross(Line line) {
        for (Line l : lines) {
            if (line.cross(l) && !line.equals(l))
                return true;
        }
        return false;
    }
}

class Line {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    public Line(int x1, int y1, int x2, int y2) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }
    public boolean cross(Line line) {
        int common = (this.x2 - this.x1) * (line.y2 - line.y1) - (this.y2 - this.y1) * (line.x2 - line.x1);
        if (common == 0)
            return false;
        int rH = (this.y1 - line.y1) * (line.x2 - line.x1) - (this.x1 - line.x1) * (line.y2 - line.y1);
        int sH = (this.y1 - line.y1) * (this.x2 - this.x1) - (this.x1 - line.x1) * (this.y2 - this.y1);
        int r = rH / common;
        int s = sH / common;
        if (r >= 0 && r <= 1 && s >= 0 && s <= 1)
            return true;
        else
            return false;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Line other = (Line) obj;
        if (x1 != other.x1 && x1 != other.x2)
            return false;
        if (x2 != other.x2 && x2 != other.x1)
            return false;
        if (y1 != other.y1 && y1 != other.y2)
            return false;

        if (y2 != other.y2 && y2 != other.y1)
            return false;
        return true;
    }
}
