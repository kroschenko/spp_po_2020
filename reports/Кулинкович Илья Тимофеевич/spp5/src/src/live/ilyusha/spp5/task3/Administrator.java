package live.ilyusha.spp5.task3;

class Administrator extends Client {

    public Administrator(String name, CreditCard card) {
        super(name, card);
    }

    public void blockCard() {
        getCard().setBlocked(true);
    }

    public void unblockCard() {
        getCard().setBlocked(false);
    }

}
