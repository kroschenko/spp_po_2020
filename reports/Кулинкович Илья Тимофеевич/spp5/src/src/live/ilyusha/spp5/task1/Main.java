package live.ilyusha.spp5.task1;

public class Main {

    public static void main(String[] args) {
        Trolleybus t1 = new Trolleybus("19a", 24, "Mukhov", 5.30, "PAZ");
        Trolleybus t2 = new Trolleybus("24", 24, "Kabachuk", 4.90, "Tesla");

        t1.goToLocation(20.63145, 17.9714);
        System.out.printf("%s abstract class\n", t2.toStringCompact());
        t2.refuel();
    }

}
