package live.ilyusha.spp5.task3;

class CreditCard extends BankAccount {

    private double currencyAmount;
    private String owner;
    private boolean blocked;

    public CreditCard(double currencyAmount, String owner, boolean blocked) {
        this.currencyAmount = currencyAmount;
        this.owner = owner;
        this.blocked = blocked;
    }

    @Override
    void purchase(String product, double price) {
        if (currencyAmount < price) {
            throw new IllegalStateException("Not enough money");
        }
        if (blocked) {
            throw new IllegalStateException("Card is blocked");
        }
        currencyAmount -= price;
        System.out.printf("%s bought %s for %f\n", owner, product, price);
    }

    /* codegen */

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    double getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(double currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

}
