package live.ilyusha.spp3;

class Triangle {

    private int a, b, c;

    Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /* helper methods */

    public boolean exists() {
        return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && a > 0 && b > 0 && c > 0;
    }

    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public void log() {
        System.out.printf(
            "triangle = %s\nexists = %s\nperimeter = %s\narea = %s\n\n",
            this.toString(), this.exists(), this.perimeter(), this.area()
        );
    }

    /* java.lang.Object */

    @Override
    public String toString() {
        return String.format("<Triangle a=%d b=%d c=%d>", a, b, c);
    }

    public boolean equals(Triangle t) {
        return t.a == a && t.b == b && t.c == c;
    }

    /* codegen */

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

}
