package com.company;

public class Car implements Vehicle {
    private String name;
    private double speed;
    private double cargoCoeff;
    private double personCoeff;
    private double seatsAmount;
    public Car(String name, double speed) { this.name = name;
        this.speed = speed;
        this.cargoCoeff = 2.5; this.personCoeff = 1.75; this.seatsAmount = 4;
    }
    public void sayBeep() { System.out.println("Beep-beep!");
    }
    @Override
    public double rideTime(double distance) {
        return distance / this.speed;
    }

    @Override
    public double rideCost(double distance) {
        return distance * personCoeff;
    }

    @Override
    public double loadCost(double distance) {
        return distance * cargoCoeff;
    }
    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + '}';
    }
}
