package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.dao.EquipmentDAO;
import sample.model.Equipment;

public class UpDateController {


    @FXML
    private TextField id;

    @FXML
    private TextField registration_number;

    @FXML
    private TextField type_equipment;

    @FXML
    private TextField manufacturer;

    @FXML
    private TextField employee;

    @FXML
    private Button bottonOk;

    private EquipmentDAO dao = new EquipmentDAO();

    private static Equipment equipment;
    private static HomeController homeController;

    @FXML
    void initialize() {

        id.setText(Integer.toString(equipment.getId()));
        id.setDisable(true);
        registration_number.setText(equipment.getRegistrationNumber());
//        registration_number.setDisable(true);
        type_equipment.setText(equipment.getTypeEquipment());
        type_equipment.setDisable(true);
        manufacturer.setText(equipment.getManufacturer());
        manufacturer.setDisable(true);
        employee.setText(equipment.getEmployee());
        employee.setDisable(true);
    }

    @FXML
    public void upDate(ActionEvent event){
        dao.upDate(equipment, registration_number.getText());
        Stage stage = (Stage) bottonOk.getScene().getWindow();
        homeController.refresh();
        stage.close();
    }

    public  static  void setEquipment(Equipment eq) {
        equipment = eq;
    }

    public static void setHomeController(HomeController home){
        homeController = home;
    }
}
