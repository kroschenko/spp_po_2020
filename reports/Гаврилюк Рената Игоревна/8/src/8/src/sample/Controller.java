package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    public TextField textFieldX;
    @FXML
    public TextField textFieldN;
    @FXML
    public Button buttonStart;
    @FXML
    public Button buttonStop;
    @FXML
    public Button buttonPause;
    @FXML
    public Button buttonResume;
    @FXML
    public Text textFieldResult;
    @FXML
    public Text textFieldError;

    private Calculator calculator;

    @FXML
    void initialize() {
        buttonStart.setVisible(true);
        buttonStop.setVisible(false);
        buttonPause.setVisible(false);
        buttonResume.setVisible(false);

        textFieldError.setText("");
        textFieldResult.setText("");
        textFieldX.setText("");
        textFieldN.setText("");
    }

    public void reinitialize() {
        buttonStart.setVisible(true);
        buttonStop.setVisible(false);
        buttonPause.setVisible(false);
        buttonResume.setVisible(false);

        textFieldError.setText("");
    }

    @FXML
    public void startClick(ActionEvent actionEvent) {
        try {
            buttonStop.setVisible(true);
            buttonPause.setVisible(true);
            textFieldError.setText("");
            textFieldResult.setText("");

            int N = Integer.parseInt(textFieldN.getText());
            int X = Integer.parseInt(textFieldX.getText());
            calculator = new Calculator(X, N, this);
            calculator.start();
        } catch (NumberFormatException e) {
            initialize();
            textFieldError.setText("Format error! Please, enter an integer number.");
        }
    }

    @FXML
    public void pauseClick(ActionEvent actionEvent) {
        buttonPause.setVisible(false);
        buttonResume.setVisible(true);
        calculator.suspend();
    }

    @FXML
    public void stopClick(ActionEvent actionEvent) {
        initialize();
        calculator.interrupt();
    }

    @FXML
    public void resumeClick(ActionEvent actionEvent) {
        buttonPause.setVisible(true);
        buttonResume.setVisible(false);
        calculator.resume();
    }

    public void updateResult(double sum) {
        textFieldResult.setText(Double.toString(sum));
    }
}
