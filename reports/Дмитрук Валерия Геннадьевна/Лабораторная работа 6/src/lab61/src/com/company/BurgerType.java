package com.company;

public enum BurgerType {

    VEGAN(2.99),
    CHICKEN(3.99);

    private Double price;
    BurgerType(Double price) {
        this.price = price;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
