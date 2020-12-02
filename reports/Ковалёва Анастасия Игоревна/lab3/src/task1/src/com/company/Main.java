package com.company;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
        Triangle first = new Triangle(8);
        Triangle second = new Triangle(3);
        first.perimeter();
        first.area();
        if (first.equals(second)) {
            System.out.println("Equals");
        } else {
            System.out.println("Not equals");
        }
    }
}

class Triangle {
    private double side;
    Triangle() {
        side = 1;
    }

    Triangle(double n) {
        side = n;
    }

    public void perimeter() {
        System.out.printf("Perimeter = %f\n", side*3);
    }

    public void area() {
        double area = (Math.pow(side, 2.0)*Math.sqrt(3.0))/4.0;
        System.out.printf("Area = %f\n", area);
    }

    public boolean equals(Triangle A) {
        if(this.side == A.side) {
            return true;
        } else {
            return false;
        }
    }
}