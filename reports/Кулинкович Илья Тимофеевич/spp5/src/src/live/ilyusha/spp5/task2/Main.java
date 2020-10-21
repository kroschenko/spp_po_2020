package live.ilyusha.spp5.task2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Analyst("John Doe", 30, 3000, 1000));
        workers.add(new Designer("Foo Bar", 30, 3500, 5000));
        workers.add(new Developer("Bar Foo", 30, 2000, 2500));
        workers.add(new Analyst("Bill Gates", 30, 1000, 3000));

        for (Worker i: workers) {
            i.goOnVacation();
            i.doWork();
        }
    }

}