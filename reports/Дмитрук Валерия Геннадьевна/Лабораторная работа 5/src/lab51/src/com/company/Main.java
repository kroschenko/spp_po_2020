package com.company;

public class Main {

    public static void main(String[] args) {
        // by interface
        Ship cargoShipOne = new CargoShip();
        System.out.println("Cargo ship one: ");
        cargoShipOne.swim();
        cargoShipOne.load();
        cargoShipOne.weight();
        Ship tankerOne = new Tanker();
        System.out.println("Tanker one: ");
        tankerOne.swim();
        tankerOne.load();
        tankerOne.weight();
        System.out.println("");
        // by class
        CargoShip cargoShipTwo = new CargoShip();
        System.out.println("Cargo ship two: ");
        cargoShipTwo.swim();
        cargoShipTwo.load();
        cargoShipTwo.weight();
        cargoShipTwo.passengers();
        Tanker tankerTwo = new Tanker();
        System.out.println("Tanker two: ");
        tankerTwo.swim();
        tankerTwo.load();
        tankerTwo.typeOfGoods();
        tankerTwo.weight();
        tankerTwo.passengers();
    }
}
