package com.company;

import java.time.LocalDate;

public class Product {
    private Integer id;
    private String name;
    private String upc;
    private String producer;
    private Double price;
    private LocalDate expiryDay;
    private Integer amount;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) { this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name;
    }
    public String getUpc() {
        return upc;
    }
    public void setUpc(String upc) { this.upc = upc;
    }
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) { this.producer = producer;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) { this.price = price;
    }
    public LocalDate getExpiryDay() {
        return expiryDay;
    }
    public void setExpiryDay(LocalDate expiryDay) { this.expiryDay = expiryDay;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) { this.amount = amount;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", upc='" + upc + '\'' +
                ", producer='" + producer + '\'' + ", price=" + price +
                ", expiryDay=" + expiryDay +
                ", amount=" + amount + '}';
    }
}
