package com.company;

import java.util.List;

public class ProductPrinter {
    public static void printProducts(String message, List<Product> products) {
        System.out.println(message);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
