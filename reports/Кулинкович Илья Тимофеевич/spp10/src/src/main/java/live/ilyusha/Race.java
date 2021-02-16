package live.ilyusha;

public class Race {
    Integer id;
    Racer winner;
    Location location;

    public Race(Integer id, Racer winner, Location location) {
        this.id = id;
        this.winner = winner;
        this.location = location;
    }
}
