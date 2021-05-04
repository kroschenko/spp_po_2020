package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.dao.EquipmentDAO;
import sample.model.Equipment;

import java.io.IOException;

public class HomeController {

    @FXML
    protected TableView<Equipment> table;

    @FXML
    private TableColumn<Equipment, String> id;

    @FXML
    private TableColumn<Equipment, String> registration_number;

    @FXML
    private TableColumn<Equipment, String> type_equipment;

    @FXML
    private TableColumn<Equipment, String> manufacturer;

    @FXML
    private TableColumn<Equipment, String> employee;

    @FXML
    private TableColumn<Equipment, String> warranty;

    ObservableList<Equipment> listview = FXCollections.observableArrayList();

    private EquipmentDAO dao = new EquipmentDAO();

    @FXML
    void initialize() {

        id.setCellValueFactory(new PropertyValueFactory<Equipment, String>("id"));
        registration_number.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        type_equipment.setCellValueFactory(new PropertyValueFactory<>("typeEquipment"));
        manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        employee.setCellValueFactory(new PropertyValueFactory<>("employee"));
        warranty.setCellValueFactory(new PropertyValueFactory<>("warranty"));

        listview.addAll(dao.getAll());
        table.setItems(listview);
    }

    @FXML
    void add(ActionEvent event) {
        try {
            FormController.setHomeController(this);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/insert.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void upDate(ActionEvent event) {
        try {
            UpDateController.setEquipment(table.getSelectionModel().getSelectedItem());
            UpDateController.setHomeController(this);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/update.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void delete(ActionEvent event) {
        Equipment equipment = table.getSelectionModel().getSelectedItem();
        dao.delete(equipment.getId());
        refresh();
    }

    public void refresh() {
        listview.clear();
        listview.addAll(dao.getAll());
        table.setItems(listview);
    }

}
