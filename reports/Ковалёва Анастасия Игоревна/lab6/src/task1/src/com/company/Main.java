package com.company;

public class Main {
    public static void main(String[] args) {
        CarFactory audiFactory = new AudiFactory();
        CarFactory bmwFactory = new bmwFactory();
        audiFactory.createCar().ride();
        bmwFactory.createCar().ride();
    }
}

interface Car {
    void ride();
}

interface CarFactory {
    Car createCar();
}

class Audi implements Car {
    @Override
    public void ride() {
        System.out.println("Audi is riding");
    }
}

class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}

class bmw implements Car {
    @Override
    public void ride() {
        System.out.println("Bmw is riding");
    }
}

class bmwFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new bmw();
    }
}

