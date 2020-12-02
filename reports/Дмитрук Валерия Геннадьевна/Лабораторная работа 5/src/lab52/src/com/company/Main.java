package com.company;
import java.util.ArrayList;

public class Main {
        public static final int DISTANCE = 70;

        public static void main(String[] args) {
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            Car car = new Car("Skoda", 60);
            vehicles.add(car);
            car.sayBeep();
            Bicycle bicycle = new Bicycle("Mustang", 15);
            vehicles.add(bicycle);
            bicycle.sayDing();
            Wagon wagon = new Wagon(12, 25);
            vehicles.add(wagon);
            wagon.sayCap();
            for (int i = 0; i < vehicles.size(); i++) {
                System.out.println("");
                System.out.println("Vehicle: " + vehicles.get(i).toString());
                System.out.println("Distance: " + DISTANCE + " kms");
                System.out.println("Time: " + vehicles.get(i).rideTime(DISTANCE) + " hours");
                System.out.println("Cost for person: " + vehicles.get(i).rideCost(DISTANCE) + " dollars");
                System.out.println("Cost for goods: " + vehicles.get(i).loadCost(DISTANCE) + " dollars");
                vehicles.get(i).ride();
            }
        }
}
