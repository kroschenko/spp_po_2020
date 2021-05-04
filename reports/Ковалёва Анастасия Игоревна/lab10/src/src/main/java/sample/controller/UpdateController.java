package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.MatchFootballDAO;
import sample.MatchFootball;

public class UpdateController {


    @FXML
    private TextField id;

    @FXML
    private TextField match_name;

    @FXML
    private TextField referee;

    @FXML
    private TextField stadion;

    @FXML
    private TextField comand;

    @FXML
    private Button buttonOk;

    private MatchFootballDAO dao = new MatchFootballDAO();

    private static MatchFootball matchFootball;
    private static HomeController homeController;

    @FXML
    void initialize() {

        id.setText(Integer.toString(matchFootball.getId()));
        id.setDisable(true);
        match_name.setText(matchFootball.getMatch_name());
        referee.setText(matchFootball.getReferee());
        referee.setDisable(true);
        stadion.setText(matchFootball.getStadion());
        stadion.setDisable(true);
        comand.setText(matchFootball.getComand());
        comand.setDisable(true);
    }

    @FXML
    public void update(ActionEvent event){
        dao.update(matchFootball, match_name.getText());
        Stage stage = (Stage) buttonOk.getScene().getWindow();
        homeController.refresh();
        stage.close();
    }

    public  static  void setMatchFootball(MatchFootball eq) {
        matchFootball = eq;
    }

    public static void setHomeController(HomeController home){
        homeController = home;
    }
}
