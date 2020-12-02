package com.company;

public class Tanker extends CargoShip {
    public void typeOfGoods() { System.out.println("My load is oil");
    }
    @Override
    public void load() {
        System.out.println("I'm carrying liquids");
    }
}
