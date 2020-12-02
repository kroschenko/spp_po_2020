package com.company;

public interface Vehicle {
    default void ride() { System.out.println("Let's go!");
    }
    double rideTime(double distance);
    double rideCost(double distance);
    double loadCost(double distance);
}
