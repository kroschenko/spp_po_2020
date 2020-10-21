package live.ilyusha.spp4.task3;

import java.util.ArrayList;

class Client {

    static class Order {

        private String id;
        private String location;
        private double value;

        public Order(String id, String location, double value) {
            this.id = id;
            this.location = location;
            this.value = value;
        }

        public String toString() {
            return String.format(
                "<Order id=\"%s\" location=\"%s\" value=%f>",
                id, location, value
            );
        }

        /* codegen */

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

    }

    private BankAccount bankAccount;
    private CreditCard creditCard;
    private String name;

    private ArrayList<Order> paymentHistory = new ArrayList<>();

    public Client(BankAccount bankAccount, CreditCard creditCard, String name) {
        this.bankAccount = bankAccount;
        this.creditCard = creditCard;
        this.name = name;
    }

    public void transferTo(BankAccount otherAccount, double amount) {
        if (bankAccount.getAmount() < amount) {
            throw new IllegalStateException("Not enough money");
        }
        if (creditCard.isBlocked()) {
            throw new IllegalStateException("Credit card is blocked");
        }
        bankAccount.setAmount(bankAccount.getAmount() - amount);
        otherAccount.setAmount(bankAccount.getAmount() + amount);
    }

    public void payForOrder(Order order) {
        if (bankAccount.getAmount() < order.getValue()) {
            throw new IllegalStateException("Not enough money");
        }
        if (creditCard.isBlocked()) {
            throw new IllegalStateException("Credit card is blocked");
        }
        bankAccount.setAmount(bankAccount.getAmount() - order.getValue());
        paymentHistory.add(order);
    }

    public void blockCard() {
        creditCard.setBlocked(true);
    }

    public void nullifyAccount() {
        bankAccount.setAmount(0);
    }

    /* codegen */

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Order> getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(ArrayList<Order> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

}
