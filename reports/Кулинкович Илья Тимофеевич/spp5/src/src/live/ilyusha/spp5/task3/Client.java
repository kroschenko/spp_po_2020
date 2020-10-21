package live.ilyusha.spp5.task3;

public class Client {

    private String name;
    private CreditCard card;

    public Client(String name, CreditCard card) {
        this.name = name;
        this.card = card;
    }

    /* codegen */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

}
