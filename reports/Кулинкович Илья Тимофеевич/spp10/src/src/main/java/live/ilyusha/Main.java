package live.ilyusha;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        DBProcess db = new DBProcess();

        Stage stage = new Stage();
        final Button resetButton = new Button("Reset table");
        resetButton.setMinWidth(200);
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    new File("sample.db").delete();
                    Thread.sleep(1000);
                    db.reconnect();
                    db.setup();
                } catch (SQLException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        final Button racesButton = new Button("Show table");
        racesButton.setMinWidth(200);
        racesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    stage.close();
                    RacesView racesView = new RacesView();
                    racesView.start(stage);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(resetButton, racesButton);
        primaryStage.setTitle("Formula 1");
        Scene scene = new Scene(root, 300, 140);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}