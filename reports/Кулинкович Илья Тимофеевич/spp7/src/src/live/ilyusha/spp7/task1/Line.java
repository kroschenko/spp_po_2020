package live.ilyusha.spp7.task1;

public class Line {

    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean intersects(Line line) {
        double a1 = (double) (y1 - y2) / (x1 - x2);
        double a2 = (double) (line.y1 - line.y2) / (line.x1 - line.x2);
        double b1 = y1 - a1 * x1;
        double b2 = line.y1 - a2 * line.x1;
        double xa = (b2 - b1) / (a1 - a2);
        return a1 != a2 && xa > Math.max(x1, line.x1) && xa < Math.min(x2, line.x2);
    }

    public boolean equals(Line line) {
        return x1 == line.x1 && x2 == line.x2 && y2 == line.y2 && y1 == line.y1;
    }

    /* codegen */

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
