package live.ilyusha;

public class Racer {
    Integer id;
    String name;
    Integer birthYear;
    Car car;

    public Racer(int id, String name, Integer birthYear, Car car) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.car = car;
    }
}
