package sample.model;

public class Manufacturer {
    int id;
    String name;
    String warranty;

    public Manufacturer( String name, String warranty) {
        this.id = id;
        this.name = name;
        this.warranty = warranty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
}
