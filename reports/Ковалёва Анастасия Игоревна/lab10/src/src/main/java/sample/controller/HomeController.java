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
import sample.MatchFootballDAO;
import sample.MatchFootball;

import java.io.IOException;

public class HomeController {

    @FXML
    protected TableView<MatchFootball> table;

    @FXML
    private TableColumn<MatchFootball, String> id;

    @FXML
    private TableColumn<MatchFootball, String> match_name;

    @FXML
    private TableColumn<MatchFootball, String> referee;

    @FXML
    private TableColumn<MatchFootball, String> stadion;

    @FXML
    private TableColumn<MatchFootball, String> comand;

    @FXML
    private TableColumn<MatchFootball, String> stadion_size;

    ObservableList<MatchFootball> listview = FXCollections.observableArrayList();

    private MatchFootballDAO dao = new MatchFootballDAO();

    @FXML
    void initialize() {

        id.setCellValueFactory(new PropertyValueFactory<MatchFootball, String>("id"));
        match_name.setCellValueFactory(new PropertyValueFactory<>("match_name"));
        referee.setCellValueFactory(new PropertyValueFactory<>("referee"));
        stadion.setCellValueFactory(new PropertyValueFactory<>("stadion"));
        comand.setCellValueFactory(new PropertyValueFactory<>("comand"));
        stadion_size.setCellValueFactory(new PropertyValueFactory<>("stadion_size"));

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
    void update(ActionEvent event) {
        try {
            UpdateController.setMatchFootball(table.getSelectionModel().getSelectedItem());
            UpdateController.setHomeController(this);
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
        MatchFootball matchFootball = table.getSelectionModel().getSelectedItem();
        dao.delete(matchFootball.getId());
        refresh();
    }

    public void refresh() {
        listview.clear();
        listview.addAll(dao.getAll());
        table.setItems(listview);
    }

}
