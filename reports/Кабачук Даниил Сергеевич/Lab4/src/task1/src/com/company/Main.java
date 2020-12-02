package com.company;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Payment payment = new Payment();
        Payment.Product productFirst = payment.new Product("Лук", 2);
        Payment.Product productSecond = payment.new Product("Хлеб", 1);
        Payment.Product productThird = payment.new Product("Чипсы", 10);
        Payment.Product productForth = payment.new Product("Вода", 7);
        Payment.Product productFifth = payment.new Product("Пиво", 1);

        payment.buyProduct(productFirst);
        payment.buyProduct(productSecond);
        payment.buyProduct(productThird);
        payment.buyProduct(productForth);
        payment.buyProduct(productFifth);

        System.out.println(payment.sum());
    }
}

class Payment {
    private List<Product> productList;
    public Payment() {
        productList = new ArrayList<>();
    }
    public Product buyProduct(Product product){
        productList.add(product);
        return product;
    }
    public int sum(){
        return productList.stream().mapToInt(Product::getPrice).sum();
    }
    public class Product {
        private String name;
        private Integer price;
        public Integer getPrice() {
            return price;
        }
        public Product(String name, Integer price) {
            this.name = name;
            this.price = price;        }
            @Override
            public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
