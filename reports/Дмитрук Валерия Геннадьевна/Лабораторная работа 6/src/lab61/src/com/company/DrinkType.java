package com.company;

public enum DrinkType {
    TEA(0.99),
    COFFEE(1.99),
    COLA(1.29),
    PEPSI(1.29);
    private Double price;
    DrinkType(Double price) {
        this.price = price;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
