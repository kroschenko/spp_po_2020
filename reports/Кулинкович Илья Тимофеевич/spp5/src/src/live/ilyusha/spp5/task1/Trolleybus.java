package live.ilyusha.spp5.task1;

class Trolleybus extends PublicTransport {

    private double ticketPrice;
    private String brand;

    public Trolleybus(String routeNumber, int seats, String driver, double ticketPrice, String brand) {
        super(routeNumber, seats, driver);
        this.ticketPrice = ticketPrice;
        this.brand = brand;
    }

    /* helper methods */

    @Override
    public void refuel() {
        System.out.printf("%s is refueling...\n", this);
    }

    @Override
    public void goToLocation(double x, double y) {
        System.out.printf("%s is driving to location (%f, %f)...\n", this, x, y);
    }

    @Override
    public String toString() {
        return String.format(
            "<Trolleybus routeNumber=\"%s\" seats=%d driver=\"%s\" ticketPrice=%f brand=\"%s\">",
            super.getRouteNumber(), super.getSeats(), super.getDriver(), ticketPrice, brand
        );
    }

    public String toStringCompact() {
        return super.toString();
    }

    /* codegen */

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
