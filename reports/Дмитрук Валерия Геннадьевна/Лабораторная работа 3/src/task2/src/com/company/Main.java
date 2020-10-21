package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ProductManager manager = new ProductManager(); manager.readFromFile("/Users/valeriadmitruk/Desktop/SPP/task2/product.txt");
        manager.toScreen();
        ProductPrinter.printProducts("Products by name: ", manager.findByName("Notebook"));
ProductPrinter.printProducts("Products by name and price limit: " , manager.findByNameAndPrice("Banana", 13.0));
        ProductPrinter.printProducts("Products by expiry date: " , manager.findByExpiryDate(LocalDate.now()));
    }
}
