package live.ilyusha.spp5.task3;

public class Main {

    public static void main(String[] args) {
        String name = "John Doe";
        Administrator a = new Administrator(name, new CreditCard(100, name, false));
        a.getCard().purchase("Coffee", 20);
        a.blockCard();
        try {
            a.getCard().purchase("Tea", 5);
        } catch (IllegalStateException e) {
            System.out.println(e.toString());
        }
    }

}