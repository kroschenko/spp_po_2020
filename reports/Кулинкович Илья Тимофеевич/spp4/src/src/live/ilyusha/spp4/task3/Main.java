package live.ilyusha.spp4.task3;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Administrator admin = new Administrator("Person Name", "MTBank");
        BankAccount account = new BankAccount("40817810099910004312", "USD");
        CreditCard card = new CreditCard("Alfa Bank", false, 765, "0184 6138 4302 7429", 12, 23);
        Client client = new Client(account, card, "I. Kulinkovich");

        client.getBankAccount().setAmount(5000);

        client.payForOrder(new Client.Order("4139", "Coffee", 30));
        client.payForOrder(new Client.Order("4141", "Phone shop", 100));

        admin.blockCard(client.getCreditCard());

        System.out.println(client.getPaymentHistory().stream().map(Client.Order::toString).collect(Collectors.joining("\n")));

        try {
            client.payForOrder(new Client.Order("4140", "Sushi", 45));
        } catch (IllegalStateException e) {
            System.out.println(e.toString());
        }
    }

}
