import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Element {
    private SimpleStringProperty product;
    private SimpleStringProperty client;
    private SimpleIntegerProperty count;
    private SimpleIntegerProperty id;
    public Element(String product, String client, int count, int id) {  this.product = new SimpleStringProperty(product);
        this.client = new SimpleStringProperty(client);
        this.count = new SimpleIntegerProperty(count);
        this.id = new SimpleIntegerProperty(id);
    }
    public String getProduct() {
        return product.get();
    }
    public void setProduct(String product) {
        this.product.set(product);
    }
    public String getClient() {
        return client.get();
    }
    public void setClient(String client) {
        this.client.set(client);
    }
    public int getCount() {
        return count.get();
    }
    public void setCount(int count) {
        this.count.set(count);
    }
    public int getId() {
        return id.get();
    }
    public void setId(int id) {
        this.count.set(id);
    }
}