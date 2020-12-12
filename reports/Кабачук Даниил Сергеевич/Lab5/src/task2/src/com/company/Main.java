package com.company;

public class Main {

    public static void main(String[] args) {
        Transporter transport[] = new Transporter[4];
        transport[0] = new Car(5,120,10);
        transport[1] = new Plane(false, 800, 100);
        transport[2] = new Train (1000, 160, 7);
        transport[3] = new Car (4, 100, 8);
        System.out.println("Авто: ");
        transport[0].discard(600, "Витебск");
        System.out.println("Самолет: ");
        transport[1].discard(500, "Могилев");
        System.out.println("Поезд: ");
        transport[2].discard(350, "Минск");
        System.out.println("Авто: ");
        transport[3].discard(100, "Брест");
    }
}

class Plane extends Transporter {
    boolean wheather;

    public Plane (boolean wheather, double speed, double price){
        this.wheather = wheather;
        this.speed = speed;
        this.price = price;
    }

    @Override void discard(double distance, String city){
        if(!this.wheather){
            check(distance, city);
        } else {
            System.out.println("Изза плохой погоды полеты отменены\n");
        }
    }

    void setWheather(){
        this.wheather = true;
    }
}

class Train extends Transporter {
    double fuel;

    public Train (double fuel, double speed, double price){
        this.fuel = fuel;
        this.speed = speed;
        this.price = price;
    }

    @Override void discard(double distance, String city){
        if(this.fuel < 1000){
            System.out.println("Недостаточно топлива.\n");
        } else {
            check(distance, city);
        }
    }

    void refuel(double fuel){
        this.fuel += fuel;
    }
}

abstract class Transporter {
    double speed;
    double price;

    abstract void discard(double distance, String city);

    void check (double distance, String city){
        double time = distance/this.speed;
        double money = time * this.price;

        System.out.println(
                "Пункт назначения: " + city +
                "\n Расстояние: " + distance +
                "\n Время: " + time +
                "\n Цена: " + money + "\n"
        );
    }
}

class Car extends Transporter {
    int passengers;

    public Car (int passengers, double speed, double price){
        this.passengers = passengers;
        this.speed = speed;
        this.price = price;
    }

    @Override void discard(double distance, String city){
        if(this.passengers > 5){
            System.out.println("Слишком много пассажиров.\n");
        } else {
            check(distance, city);
        }
    }

    void getOut(int passengers){
        this.passengers -= passengers;
    }
}
