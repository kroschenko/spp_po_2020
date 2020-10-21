package live.ilyusha.spp3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Bus> buses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        if (args.length > 0 && args[0].equals("1")) {
            task1();
        } else if (args.length > 0 && args[0].equals("2")) {
            task2();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void task1() {
        Triangle t1 = new Triangle(2,3,4);
        t1.log();

        Triangle t2 = new Triangle(3,4,5);
        t2.log();

        Triangle t3 = new Triangle(3, 6, 5);
        System.out.printf("%s and %s are%s equal", t2, t3, t2.equals(t3) ? "" : "n't");
    }

    public static void task2() throws IOException {
        showMenu();
        buses = readInfo("resources/data.json");
        var actions = new Runnable[] {
            Main::listBuses,
            Main::listEnRouteBuses,
            Main::listParkedBuses,
            Main::lookUpBusesByRoute,
            Main::listsBusesOperating10Years,
            Main::listBusesOperating10000Km
        };
        while (true) {
            int i = Integer.parseInt(scanner.nextLine());
            if (i > 0 && i <= actions.length) {
                actions[i - 1].run();
            } else {
                System.out.println("User abort");
                break;
            }
        }
    }

    /* task2 methods */

    private static void showMenu() {
        System.out.println("[0] exit");
        System.out.println("[1] list buses");
        System.out.println("[2] list en route buses");
        System.out.println("[3] list parked buses");
        System.out.println("[4] look up buses by route");
        System.out.println("[5] list buses operating for ≥ 10 years");
        System.out.println("[6] list buses operating for ≥ 100000 km");
    }

    private static void listBuses() {
        for (Bus bus: buses) {
            System.out.println(bus.toString());
        }
    }

    private static void listEnRouteBuses() {
        for (Bus bus: buses) {
            if (!bus.isParked()) {
                System.out.println(bus);
            }
        }
    }

    private static void listParkedBuses() {
        for (Bus bus: buses) {
            if (bus.isParked()) {
                System.out.println(bus);
            }
        }
    }

    private static void lookUpBusesByRoute() {
        System.out.println("Enter the route:");
        int route = Integer.parseInt(scanner.nextLine());

        for (Bus bus: buses) {
            if (bus.getRouteNumber() == route) {
                System.out.println(bus);
            }
        }
    }

    private static void listsBusesOperating10Years() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (Bus bus: buses) {
            if (year - bus.getYear() >= 10) {
                System.out.println(bus);
            }
        }
    }

    private static void listBusesOperating10000Km() {
        for (Bus bus: buses) {
            if (bus.getMileage() >= 100000) {
                System.out.println(bus);
            }
        }
    }

    private static ArrayList<Bus> readInfo(String fileName) throws IOException {
        return mapper.readValue(
            new File(fileName),
            mapper.getTypeFactory().constructCollectionType(ArrayList.class, Bus.class)
        );
    }

}
