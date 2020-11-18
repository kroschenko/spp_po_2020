package com.company;

public class Main {

    public static void main(String[] args) {
        // car one
        Car skoda = new Car("Skoda", 2018);
        for (int i = 0; i < 4; i++) {
            skoda.addWheel(55, "Summer");
        }
        System.out.println("Skoda:");
        skoda.ride();

        // car two
        Car volvo = new Car("Volvo", 1999);
        for (int i = 0; i < 3; i++) {
            volvo.addWheel(55, "Winter");
        }
        volvo.addWheel(57, "Winter");
        System.out.println("Volvo:");
        volvo.ride();
    }
}
