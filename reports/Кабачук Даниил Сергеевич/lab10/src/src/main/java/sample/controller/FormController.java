package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.dao.EquipmentDAO;
import sample.model.Equipment;
import sample.model.Manufacturer;

public class FormController{

    @FXML
    private TextField id;

    @FXML
    private TextField registration_number;

    @FXML
    private ComboBox<String> employee;


    @FXML
    private ComboBox<String> manufacturer;

    @FXML
    private ComboBox<String> type_equipment;

    @FXML
    private Button bottonOk;

    private EquipmentDAO dao = new EquipmentDAO();

    private static HomeController homeController;

    Equipment equipment;


    @FXML
    void initialize() {
        employee.setItems(getEmployee());
        manufacturer.setItems(getManufacturer());
        type_equipment.setItems(getTypes());
    }

    @FXML
    void insert(ActionEvent event) {

        equipment = new Equipment(Integer.parseInt(id.getText()), registration_number.getText(),
        type_equipment.getValue(), manufacturer.getValue(), employee.getValue());
        dao.insertEquipment(equipment);
        homeController.refresh();
        Stage stage = (Stage) bottonOk.getScene().getWindow();
        stage.close();

    }

    public static void setHomeController(HomeController home){
        homeController = home;
    }

    ObservableList<String> getEmployee(){
        ObservableList<String> disks = FXCollections.observableArrayList();
        disks.addAll(dao.getEmployees());
        return disks;
    }

    ObservableList<String> getManufacturer(){
        ObservableList<String> disks = FXCollections.observableArrayList();
        disks.addAll(dao.getManufacturers());
        return disks;
    }

    ObservableList<String> getTypes(){
        ObservableList<String> disks = FXCollections.observableArrayList();
        disks.addAll(dao.getTypeEquipment());
        return disks;
    }
}
