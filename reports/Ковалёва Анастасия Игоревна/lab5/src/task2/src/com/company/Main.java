package com.company;
import java.util.ArrayList;

enum Cities {
    Brest,
    Minsk,
    Moscow,
    Gomel,
    London
}

enum VehicleType {
    Car,
    Plain,
    Train
}

class Route {
    private double time;
    private Cities city;
    private int cost;

    Route(Cities city, int cost, double time) {
        this.city = city;
        this.cost = cost;
        this.time = time;
    }

    void show() {
        System.out.println("Route to " + city);
        System.out.println("Time: " + time + " Cost: " + cost);
    }

    int getCost() {
        return cost;
    }

    Cities getCity() {
        return city;
    }

    double getTime() {
        return time;
    }
}

abstract class Vehicle {
    private String model;
    private VehicleType type;
    private ArrayList<Route> routes;

    Vehicle(String model, VehicleType type) {
        this.model = model;
        this.type = type;
        routes = new ArrayList<Route>();
    }

    void calculate(double length) { }

    void show() {
        boolean hasRoutes = !routes.isEmpty();
        System.out.println("Vehicle: " + type + " .Model: " + model);
        if (!hasRoutes) {
            System.out.println("No routes");
        } else {
            for (Route route : routes) {
                route.show();
            }
        }
        System.out.println();
    }

    void findRouteTo(Cities city) {
        System.out.println("Routes to " + city);
        System.out.println("Vehicle (" + type + ") :" + model);
        for (Route route : routes) {
            if (route.getCity() == city) {
                route.show();
            }
        }
        System.out.println();
    }

    boolean hasRouteTo(Cities city) {
        for (Route route : routes) {
            if (route.getCity() == city) {
                return true;
            }
        }
        return false;
    }

    void addNewWay(Route route) {
        routes.add(route);
    }

    VehicleType getType() {
        return type;
    }

    String getModel() {
        return model;
    }
}

class Container {
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    void searchVehicleTo(Cities city) {
        boolean hasRoute = false;
        System.out.println("Vehicles to " + city);
        for (Vehicle vehicle : vehicles)
            if (vehicle.hasRouteTo(city)) {
                vehicle.findRouteTo(city);
                hasRoute = true;
            }
        if (hasRoute == false)
            System.out.println("No one goes to " + city);
    }

    void search(double length) {
        boolean t = false;
        for (Vehicle obj : vehicles)
            if (obj.getType() == VehicleType.Car) {
                obj.calculate(length);
                t = true;
            }
        if (t == false)
            System.out.println("No vehicles");
    }

    void show() {
        for (Vehicle vehicle : vehicles) {
            vehicle.show();
        }
    }
}

class Plane extends Vehicle {
    Plane(String model) {
        super(model, VehicleType.Plain);
    }

    @Override
    void show() {
        super.show();
    }
}

class Train extends Vehicle {
    Train(String model) {
        super(model, VehicleType.Train);
    }

    @Override
    void show() {
        super.show();
    }
}

class Car extends Vehicle {
    private double speed;
    private double price;

    @Override
    public void show() {
        super.show();
        System.out.println("Price for 100 km/h:" + price);
    }

    public Car(String model, double speed, double price) {
        super(model, VehicleType.Car);
        this.speed = speed;
        this.price = price;
    }

    @Override
    public void calculate(double length) {
        double time = length / speed;
        double cost = length * price / 100;
        System.out.println("Vehicle (" + this.getType() + ") :" + this.getModel());
        System.out.print("Price: ");
        System.out.printf(String.format("%.2f \n", cost).replace(",", "."));
        System.out.print("Time: ");
        System.out.printf(String.format("%.2f \n", time).replace(",", "."));
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        Route route1 = new Route(Cities.Moscow, 345, 1.2);
        Route route2 = new Route(Cities.London, 400, 3.4);
        Route route3 = new Route(Cities.Minsk, 120, 0.2);
        Route route4 = new Route(Cities.Brest, 230, 2);
        Route route5 = new Route(Cities.Gomel, 500, 1);
        Plane air1 = new Plane("AAA");
        Plane air2 = new Plane("BBB");
        Train train1 = new Train("Express");
        Car car1 = new Car("bmw", 90, 100);
        Car car2 = new Car("reno", 70, 40);

        container.add(air1);
        container.add(air2);
        container.add(car1);
        container.add(car2);
        container.add(train1);

        air1.addNewWay(route1);
        air1.addNewWay(route2);
        air2.addNewWay(route3);
        air2.addNewWay(route4);
        air2.addNewWay(route5);
        car2.addNewWay(route3);
        train1.addNewWay(route5);

        System.out.println("Search vehicles to Moscow");
        System.out.println("------------------");
        container.searchVehicleTo(Cities.Moscow);
        System.out.println("------------------");
        System.out.println("Calculate pricae for route 500 km by car");
        System.out.println("------------------");
        container.search(500);
        System.out.println("------------------");
        System.out.println("Show all");
        System.out.println("------------------");
        container.show();
    }
}




