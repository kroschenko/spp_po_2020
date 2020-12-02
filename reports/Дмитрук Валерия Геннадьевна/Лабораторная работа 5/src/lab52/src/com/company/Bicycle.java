package com.company;

public class Bicycle implements Vehicle {
    private String name;
    private double speed;
    private double cargoCoeff;
    private double personCoeff;

    public Bicycle(String name,double speed){
        this.name = name;
         this.speed = speed;
         this.cargoCoeff = 0.75;
         this.personCoeff = 0.5;
    }

    public void sayDing() {
        System.out.println("Ding-ding!");
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
        return "Bicycle{" + "name='" + name + '\'' + '}';
    }
}
