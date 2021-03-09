package main;

import entity.Reader;
import entity.ReaderHistory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controllers.ReaderCardFormController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       // ReaderCardFormController.reader = new Reader(1, "name", "name", "name", "name");
        //ReaderCardFormController.readerHistory = new ReaderHistory(1, "2021-02-07","2021-02-27",1);
        //ReaderCardFormController.STATE = false;
        Parent root = FXMLLoader.load(getClass().getResource("assets/reader.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("assets/readerCardForm.fxml"));
        primaryStage.setTitle("Lab 9 Hauryliuk");
        primaryStage.setScene(new Scene(root, 1000, 800));
       // primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
