package live.ilyusha.spp5.task1;

abstract class PublicTransport implements Transport {

    private String routeNumber;
    private int seats;
    private String driver;

    public PublicTransport(String routeNumber, int seats, String driver) {
        this.routeNumber = routeNumber;
        this.seats = seats;
        this.driver = driver;
    }

    /* helper methods */

    public String toString() {
        return String.format(
            "<PublicTransport routeNumber=\"%s\" seats=%d driver=\"%s\">",
            routeNumber, seats, driver
        );
    }

    /* abstract methods */

    public abstract void refuel();

    /* codegen */

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

}
