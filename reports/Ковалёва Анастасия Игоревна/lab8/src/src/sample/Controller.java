package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ResourceBundle;

public class Controller {

    private Calculator calculator;
    private boolean isRunning = false;

    @FXML
    private TextField textFieldX, textFieldN;

    @FXML
    private Button startBut, pauseBut, stopBut, resumeBut;

    @FXML
    private Text resultText, errorText;

    @FXML
    void initialize() {
        pauseBut.setDisable(true);
        stopBut.setDisable(true);
    }

    @FXML
    void startClick() {
        try {
            int N = Integer.parseInt(textFieldN.getText());
            int X = Integer.parseInt(textFieldX.getText());
            calculator = new Calculator(N, X, this);
            startBut.setDisable(true);
            pauseBut.setDisable(false);
            stopBut.setDisable(false);
            resumeBut.setDisable(true);
            errorText.setText("");
            isRunning = true;
            calculator.start();
        } catch (NumberFormatException e) {
            errorText.setText("Format error! Please, enter an integer number.");
        }
    }

    @FXML
    synchronized void pauseClick() throws InterruptedException {
        if (isRunning) {
            resumeBut.setDisable(false);
            calculator.suspend();
            isRunning = false;
        }
    }

    @FXML
    synchronized void resumeClick() {
        if (!isRunning) {
            isRunning = true;
            calculator.resume();
            resumeBut.setDisable(true);
        }
    }

    @FXML
    void stopClick() {
        startBut.setDisable(false);
        pauseBut.setDisable(true);
        stopBut.setDisable(true);
        resumeBut.setDisable(true);
        calculator.interrupt();
    }

    void updateResult(double sum) {
        resultText.setText(Double.toString(sum));
    }
}
