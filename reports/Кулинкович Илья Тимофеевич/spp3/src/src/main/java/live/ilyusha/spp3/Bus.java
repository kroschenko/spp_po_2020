package live.ilyusha.spp3;

class Bus {

    private String driver;
    private int plateNumber;
    private int routeNumber;
    private String brand;
    private int year;
    private double mileage;
    private boolean parked;

    public Bus() {}

    public Bus(String driver, int plateNumber, int routeNumber, String brand, int year, double mileage, boolean parked) {
        this.setDriver(driver);
        this.setPlateNumber(plateNumber);
        this.setRouteNumber(routeNumber);
        this.setBrand(brand);
        this.setYear(year);
        this.setMileage(mileage);
        this.setParked(parked);
    }

    @Override
    public String toString() {
        return String.format(
            "<Bus driver=\"%s\" plateNumber=%d routeNumber=%d brand=\"%s\" year=%d mileage=%f parked=%s>",
            getDriver(), getPlateNumber(), getRouteNumber(), getBrand(), getYear(), getMileage(), isParked()
        );
    }

    /* codegen */

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public boolean isParked() {
        return parked;
    }

    public void setParked(boolean parked) {
        this.parked = parked;
    }

}
