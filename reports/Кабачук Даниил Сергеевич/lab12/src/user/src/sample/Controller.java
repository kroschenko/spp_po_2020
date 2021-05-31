package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller extends View implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button threeButton;

    @FXML
    private Button startButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button oneButton;

    @FXML
    private Label label;

    @FXML
    private Label messageLabel;

    @FXML
    Game game = new Game();

    @FXML
    void startClick(ActionEvent event) {
        displayStart();
    }

    @FXML
    void oneClick(ActionEvent event) {
        displayStep(1);
    }

    @FXML
    void twoClick(ActionEvent event) {
        displayStep(2);

    }

    @FXML
    void threeClick(ActionEvent event) {
        displayStep(3);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        super.game = game;

        messageLabel.setText("Click \"Start\"");
        label.setText("20");

        game.scoreProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                label.setText(t1);
            }
        });

        game.messageProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                messageLabel.setText(t1);
            }
        });
    }
}
