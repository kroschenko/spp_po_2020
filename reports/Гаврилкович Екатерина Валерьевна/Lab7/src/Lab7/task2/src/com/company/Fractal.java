import java.awt.*;
import java.awt.event.*;
public class Fractal extends Frame {
    public static void main(String[] args) {new Fractal();}
    Fractal(){addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e)
    {System.exit(0);}});
        setSize(800,800);
        add("Center", new CvDraw());
        show();
    }
}
class Point2D{
    int x, y;
    Point2D(int x, int y){this.x = x; this.y = y;}
}
class CvDraw extends Canvas{
    int limitCount = 0;
    public void paint(Graphics g)
    {
        drawTree(g, 350,650,450,650,8);
    }
    private void drawTree(Graphics g, int x1, int y1, int x2, int y2, int limit )
    {
        if (limit == limitCount)
            return;
        int u1 = x2-x1;
        int u2 = y2-y1;
        Point2D A = new Point2D(x1, y1);
        Point2D B = new Point2D(x2, y2);
        Point2D C = new Point2D(B.x + u2, B.y - u1);
        Point2D D = new Point2D(A.x + u2, A.y - u1);
        Point2D E = new Point2D(D.x + ((u1+u2)/2), D.y + ((u2-u1)/2)); //
        g.drawLine(A.x, A.y, B.x, B.y);
        g.drawLine(B.x, B.y, C.x, C.y);
        g.drawLine(C.x, C.y, D.x,D.y);
        g.drawLine(D.x, D.y, A.x, A.y);
        int xPoints[] = {A.x, B.x, C.x, D.x};
        int yPoints[] = {A.y, B.y, C.y, D.y};
        g.fillPolygon(xPoints,yPoints,4);
        drawTree(g, E.x, E.y, C.x, C.y, limit-1);
        drawTree(g, D.x, D.y, E.x, E.y, limit-1);
    }
}