package com.company;

public class Bill {
    private Float price;
    private Integer seatNumber;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Bill{" + "price=" + price + ", seatNumber=" + seatNumber + '}';
    }
}
