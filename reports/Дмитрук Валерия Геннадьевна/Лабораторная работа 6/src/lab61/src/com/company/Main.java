package com.company;


public class Main {

    public static void main(String[] args) {
        Order myOrder = new Order.Builder()
                .withBurger(BurgerType.CHICKEN)
                .withBurger(BurgerType.CHICKEN)
                .withDrink(DrinkType.COLA)
                .withPacking(PackingType.TAKEAWAY)
                .build();
        System.out.println(myOrder);

        Order myOrderTwo = new Order.Builder()
                .withBurger(BurgerType.VEGAN)
                .withDrink(DrinkType.COFFEE)
                .withPacking(PackingType.IN)
                .build();
        System.out.println(myOrderTwo); }
}
