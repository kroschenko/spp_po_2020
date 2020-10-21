package live.ilyusha.spp4.task3;

class BankAccount {

    private String number;
    private String currency;
    private double amount = 0;

    public BankAccount(String number, String currency) {
        this.number = number;
        this.currency = currency;
    }

    /* codegen */

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
