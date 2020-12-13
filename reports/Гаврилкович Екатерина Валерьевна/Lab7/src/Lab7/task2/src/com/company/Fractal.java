import javax.swing.*;
import java.awt.*;

public class Fractal extends JPanel {
    private final static int X1 = 150;
    private final static int Y1 = 350;
    private final static int X2 = 450;
    private final static int Y2 = 350;
    private final static int AMT_OF_ITERATIONS = 20;
    public void paintComponent(Graphics graphics) {
        super.paintComponents(graphics);
        graphics.setColor(Color.ORANGE);
        draw(X1, Y1, X2, Y2, AMT_OF_ITERATIONS, graphics);
    }
    private void draw(int x1, int y1, int x2, int y2, int amtOfIterations, Graphics graphics) {
        if (amtOfIterations == 0) {
            graphics.drawLine(x1, y1, x2, y2);
        } else {
            int xx = (x1 + x2) / 2 + (y2 - y1) / 2;
            int yy = (y1 + y2) / 2 - (x2 - x1) / 2;
            draw(x1, y1, xx, yy, amtOfIterations - 1, graphics);
            draw(xx, yy, x2, y2, amtOfIterations - 1, graphics);
        }
    }
}

class Main {
    public final static int WIDTH = 613;
    public final static int HEIGHT = 490;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Фрактал Леви");
        frame.setSize(WIDTH, HEIGHT);
        frame.setContentPane(new Fractal());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
