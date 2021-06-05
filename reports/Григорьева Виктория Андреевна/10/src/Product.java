public class Product {
    private int id;
    private String name;
    private double cost;
    private int type;
    public Product(int id, String name, double cost, int type) {  this.id = id;
        this.name = name;
        this.cost = cost;
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }
    public int getType() {
        return type;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setType(int type) {
        this.type = type;
    }
}
