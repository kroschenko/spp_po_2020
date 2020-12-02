package com.company;

public class Wagon implements Vehicle {

    private int number;
    private double speed;
    private double cargoCoeff;
    private double personCoeff;
    private double horseAmount;

    public Wagon(int number, double speed) {
        this.number = number;
        this.speed = speed;
        this.cargoCoeff = 1.25;
        this.personCoeff = 0.75;
        this.horseAmount = 4;
    }

    public void sayCap() {
        System.out.println("Cap-cap!");
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
        return "Wagon{" + "number=" + number + '}';
    }
}
