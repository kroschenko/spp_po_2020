import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

class Item
{
    public int id;
    public String text;
    public Item(int id, String text)
    {
        this.id=id;
        this.text=text;
    }
}
public class AdderController implements Initializable {
    @FXML
    public ComboBox comboBoxProducts;
    @FXML
    public ComboBox comboBoxClients;
    @FXML
    public TextField textAreaCount;
    @FXML
    public Button buttonAdd;
    private int id;
    private int mode;
    private List<Product> products;
    private List<Client> clients;
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {}
    public void start(int mode, int id)
    {
        this.id=id;
        this.mode=mode;
        try {
            DatabaseController DBController = new DatabaseController();  products=DBController.getProducts();
            clients=DBController.getClients();
            ObservableList<Item> listProducts = FXCollections.observableArrayList();  ObservableList<Item> listClients = FXCollections.observableArrayList();
            for(int i=0; i<products.size(); i++)
                listProducts.add(new Item(products.get(i).getId(),  products.get(i).getName()));
            for(int i=0; i<clients.size(); i++)
                listClients.add(new Item(clients.get(i).getId(),  clients.get(i).getSurname()+" "+clients.get(i).getName()));
            comboBoxProducts.setItems(listProducts);
            comboBoxClients.setItems(listClients);
            Callback<ListView<Item>, ListCell<Item>> factory = new  Callback<ListView<Item>, ListCell<Item>>() {
                @Override
                public ListCell<Item> call(ListView<Item> l) {
                    return new ListCell<Item>() {
                        @Override
                        protected void updateItem(Item item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item == null || empty) {
                                setGraphic(null);
                            } else {
                                setText(item.text);
                            }
                        }
                    } ;
                }
            };
            comboBoxProducts.setCellFactory(factory);
            comboBoxProducts.setButtonCell(factory.call(null));  comboBoxClients.setCellFactory(factory);
            comboBoxClients.setButtonCell(factory.call(null));
            if(mode==1) {
                buttonAdd.setText("Обновить");
                List<Element> list = DBController.getProductsClients(); for (int i = 0; i < list.size(); i++)
                    if (list.get(i).getId() == id) {
                        int idProduct =
                                DBController.getProductInProductsClientsById(id);
                        for (int j = 0; j < products.size(); j++)  if (products.get(j).getId() == idProduct) {  comboBoxProducts.getSelectionModel().select(j); break;
                        }
                        int idClient =
                                DBController.getClientInProductsClientsById(id);
                        for (int j = 0; j < clients.size(); j++)  if (clients.get(j).getId() == idClient) {  comboBoxClients.getSelectionModel().select(j);  break;
                        }

                        textAreaCount.setText(String.valueOf(DBController.getCountInProductsClientsById(id)));  break;
                    }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void addButtonClick(javafx.event.ActionEvent actionEvent) {  try {
        Item product = (Item) comboBoxProducts.getValue();
        Item client = (Item) comboBoxClients.getValue();
        int count=Integer.parseInt(textAreaCount.getText());
        if(count<=0)
            throw new Exception();
        DatabaseController DBController = new DatabaseController();  boolean result;
        if(mode==0)
            result=DBController.addNewRecord(product.id, client.id, count);  else
            result=DBController.updateRecord(id, product.id, client.id, count);  if(!result)
            throw new Exception();
        Node node=(Node)actionEvent.getSource();
        Stage stage=(Stage)node.getScene().getWindow();
        stage.close();
    }
    catch(Exception e)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);  alert.setTitle("Ошибка");
        alert.setHeaderText("Произошла ошибка");
        alert.setContentText("Указаны неверные данные.");  alert.showAndWait();
        e.printStackTrace();
    }
    }
}