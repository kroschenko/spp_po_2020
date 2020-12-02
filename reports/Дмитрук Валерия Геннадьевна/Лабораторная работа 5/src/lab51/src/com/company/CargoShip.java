package com.company;

public class CargoShip implements Ship {
    @Override
    public void load() {
        System.out.println("I'm carrying goods");
    }
    @Override
    public void weight() {
        System.out.println("My weight is 150 tonnes");
    }
    public void passengers(){
        System.out.println("I have no passengers!");
    }
}
