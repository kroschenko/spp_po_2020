import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TableView<Element> table;
    @FXML
    public TableColumn<Element, String> tableItemProduct;
    @FXML
    public TableColumn<Element, String> tableItemClient;
    @FXML
    public TableColumn<Element, Integer> tableItemCount;
    @FXML
    public TableColumn<Element, Integer> tableItemId;
    @FXML
    public CheckBox checkBox;
    @FXML
    public TextField textArea;
    @FXML
    public Button searchButton;
    DatabaseController DBController;
    boolean searchState=false;
    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        tableItemProduct.setCellValueFactory(new PropertyValueFactory<>("product"));  tableItemClient.setCellValueFactory(new PropertyValueFactory<>("client"));  tableItemCount.setCellValueFactory(new PropertyValueFactory<>("count"));
        try {
            DBController = new DatabaseController();
        }
        catch(Exception e){System.out.println("Exception "+e.toString());}
        updateTable();
    }
    void updateTable()
    {
        try {
            List<Element> list=DBController.getProductsClients();  if(checkBox.isSelected())
            {
                class comparator implements Comparator<Element>
                {
                    public int compare(Element a, Element b)
                    {
                        return a.getProduct().compareTo(b.getProduct());  }
                }
                list.sort(new comparator());
            }
            if(searchState)
                for(int i=0; i<list.size(); i++)
                    if(!list.get(i).getProduct().contains(textArea.getText())) {  list.remove(i);
                        i--;
                    }
            ObservableList<Element> tableItemsList= FXCollections.observableArrayList();  for(int i = 0; i<list.size(); i++)
                tableItemsList.add(list.get(i));
            table.setItems(tableItemsList);
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e.toString());
        }
    }
    public void clickCheckBox(javafx.event.ActionEvent actionEvent)
    {
        updateTable();
    }
    public void clickSearchButton(javafx.event.ActionEvent actionEvent)
    {
        if(textArea.getText().isEmpty())
            searchState=false;
        else
            searchState=true;
        updateTable();
    }
    public void clickDeleteButton(javafx.event.ActionEvent actionEvent)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Внимание");
        alert.setHeaderText("Подтвердите удаление");
        alert.setContentText("Вы точно хотите удалить запись?");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                try {

                    DBController.deleteRow(table.getSelectionModel().getSelectedItem().getId());  updateTable();
                }
                catch(Exception e)
                {
                    System.out.println("Exception "+e.toString());
                }
            }
        });
    }
    public void clickAddButton(javafx.event.ActionEvent actionEvent)
    {
        initializeAddWindow(0, 0);
    }
    public void clickUpdateButton(javafx.event.ActionEvent actionEvent)
    {
        try{
            int id=table.getSelectionModel().getSelectedItem().getId();  initializeAddWindow(1, id);
        }
        catch(Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Произошла ошибка");
            alert.setContentText("Проверьте, указали ли вы запись для обновления.");  alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
            }
        });
            e.printStackTrace();
        }
    }
    public void initializeAddWindow(int mode, int id)
    {
        try {
            FXMLLoader loader= new FXMLLoader(this.getClass().getResource("adder.fxml"));  Parent root = (Parent)loader.load();
            Stage addWindow = new Stage();
            addWindow.initModality(Modality.APPLICATION_MODAL);
            if(mode==0)
                addWindow.setTitle("Добавить");
            else
                addWindow.setTitle("Обновить");
            addWindow.setScene(new Scene(root, 300, 300));
            addWindow.setMinHeight(300);
            addWindow.setMinWidth(300);
            addWindow.setMaxHeight(300);
            addWindow.setMaxWidth(300);
            addWindow.setOnHiding(event1 -> {
                System.out.println("CLOSED");
                updateTable();
            });
            AdderController adderController = loader.getController();
            adderController.start(mode, id);
            addWindow.show();
        }
        catch(Exception e)
        {
            System.out.println("Exception"+e.toString());
            e.printStackTrace();
        }
    }
}