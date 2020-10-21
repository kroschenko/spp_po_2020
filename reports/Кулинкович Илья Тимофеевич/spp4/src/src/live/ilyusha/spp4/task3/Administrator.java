package live.ilyusha.spp4.task3;

public class Administrator {

    private String name;
    private String company;

    public Administrator(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public void blockCard(CreditCard card) {
        card.setBlocked(true);
    }

    public void unblockCard(CreditCard card) {
        card.setBlocked(false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
