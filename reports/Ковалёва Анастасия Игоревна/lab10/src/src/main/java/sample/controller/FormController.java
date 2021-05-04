package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.MatchFootballDAO;
import sample.MatchFootball;

public class FormController{

    @FXML
    private TextField id;

    @FXML
    private TextField match_name;

    @FXML
    private ComboBox<String> comand;

    @FXML
    private ComboBox<String> stadion;

    @FXML
    private ComboBox<String> referee;

    @FXML
    private Button bottonOk;

    private MatchFootballDAO dao = new MatchFootballDAO();

    private static HomeController homeController;

    MatchFootball matchFootball;


    @FXML
    void initialize() {
        comand.setItems(getComand());
        stadion.setItems(getStadion());
        referee.setItems(getReferee());
    }

    @FXML
    void insert(ActionEvent event) {

        matchFootball = new MatchFootball(
                Integer.parseInt(id.getText()),
                match_name.getText(),
                referee.getValue(),
                stadion.getValue(),
                comand.getValue()
        );
        dao.insertMatchFootball(matchFootball);
        homeController.refresh();
        Stage stage = (Stage) bottonOk.getScene().getWindow();
        stage.close();

    }

    public static void setHomeController(HomeController home){
        homeController = home;
    }

    ObservableList<String> getComand(){
        ObservableList<String> disks = FXCollections.observableArrayList();
        disks.addAll(dao.getComand());
        return disks;
    }

    ObservableList<String> getStadion(){
        ObservableList<String> disks = FXCollections.observableArrayList();
        disks.addAll(dao.getStadion());
        return disks;
    }

    ObservableList<String> getReferee(){
        ObservableList<String> disks = FXCollections.observableArrayList();
        disks.addAll(dao.getReferee());
        return disks;
    }
}
