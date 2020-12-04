package com.company;

public enum PackingType {
    TAKEAWAY(0.49),
    IN(0.00);
    private Double price;
    PackingType(Double price) {
        this.price = price;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
