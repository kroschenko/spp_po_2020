package com.company;

public class Main {

    public static void main(String[] args) {
        IsoscelesTriangle emptyTriangle = new IsoscelesTriangle();
        System.out.println(emptyTriangle.toString());

        IsoscelesTriangle validTriangle = new IsoscelesTriangle(3, 4);
        System.out.println(validTriangle.toString());
        try {
            IsoscelesTriangle invalidTriangle = new IsoscelesTriangle(10000, 2);
        } catch(IllegalArgumentException e) {
            System.out.println("Can't create!");
        }
    }
}

class IsoscelesTriangle {

    private double base;
    private double side;

    public IsoscelesTriangle() {
        base = side = 0;
    }

    public IsoscelesTriangle(double base, double side) {
        this.base = base;
        this.side = side;
        if(!isValid()) throw new IllegalArgumentException();
    }

    public boolean isValid() {
        return side * 2 > base && base > 0 && side > 0;
    }

    public double area() {
        if(!isValid()) throw new IllegalArgumentException();
        return base * Math.sqrt(4 * side * side - base * base) / 4;
    }

    public double perimeter() {
        if(!isValid()) throw new IllegalArgumentException();
        return base + side * 2;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj instanceof IsoscelesTriangle) return false;

        IsoscelesTriangle converted = (IsoscelesTriangle) obj;
        return this.side == converted.side && this.base == converted.base;
    }

    @Override
    public String toString() {
        String area = isValid() ? String.valueOf(area()) : "No"; String perimeter = isValid() ? String.valueOf(area()) : "No";
        return "Triangle: {\n" +
                "\tbase:" + base + ",\n" +
                "\tside:" + side + ",\n" +
                "\tarea:" + area + ",\n" + "\tperimeter:" + perimeter + "\n}\n";
    }
}
