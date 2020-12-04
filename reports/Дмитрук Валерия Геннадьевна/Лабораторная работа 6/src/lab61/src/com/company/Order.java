package com.company;
import java.util.ArrayList;

public class Order {
    private ArrayList<BurgerType> burgers;
    private ArrayList<DrinkType> drinks;
    private PackingType packing;
    private Double totalCost;
    public Order() {
        this.burgers = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.totalCost = 0.00;
    }
    public ArrayList<BurgerType> getBurgers() {
        return burgers;
    }
    public ArrayList<DrinkType> getDrinks() {
        return drinks;
    }
    public PackingType getPacking() {
        return packing;
    }
    public Double getTotalCost() {
        return totalCost;
    }
    public static class Builder {
        private Order newOrder;

        public Builder() {
            newOrder = new Order();
        }

        public Builder withBurger(BurgerType burger) {
            newOrder.burgers.add(burger);
            return this;
        }

        public Builder withDrink(DrinkType drink) {
            newOrder.drinks.add(drink);
            return this;
        }

        public Builder withPacking(PackingType packing) {
            newOrder.packing = packing;
            return this;
        }

        public Order build() {
            for (BurgerType burger : newOrder.burgers) {
                newOrder.totalCost += burger.getPrice();
            }
            for (DrinkType drink : newOrder.drinks) {
                newOrder.totalCost += drink.getPrice();
            }
            newOrder.totalCost += newOrder.packing.getPrice();
            return newOrder;
        }

    }
@Override
public String toString() {
        return "Task1.Order{" +
        "burgers=" + burgers +
        ", drinks=" + drinks +
        ", packing=" + packing +
        ", totalCost=" + totalCost + '}';}
}
