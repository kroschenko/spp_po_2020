package live.ilyusha.spp6.task1;

public class Main {

    public static void main(String[] args) {
        FastFoodOrder order = new FastFoodOrder.Builder("Kulinkovich I.T.")
            .setBurger(FastFoodOrderBurgerType.CHEESEBURGER_WITH_BACON)
            .setDrink(FastFoodOrderDrinkType.SPRITE)
            .setSide(FastFoodOrderSideType.MOZZARELLA_STICKS)
            .setLocation(FastFoodLocationType.IN_RESTAURANT)
            .build();

        System.out.println(order.toString());
    }

}
