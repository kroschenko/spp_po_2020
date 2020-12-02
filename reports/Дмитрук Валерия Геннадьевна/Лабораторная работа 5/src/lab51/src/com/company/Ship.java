package com.company;

public interface Ship {
    default void swim() {
        System.out.println("I can swim in the sea!");
    }
    void weight();
    void load();
}
