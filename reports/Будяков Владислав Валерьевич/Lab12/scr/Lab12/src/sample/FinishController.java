package sample;
import java.io.IOException; import java.net.URL;
import java.util.ResourceBundle; import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button; import javafx.scene.text.Text; import javafx.stage.Stage;
public class FinishController {
    @FXML
private Button ok_btn;
    @FXML
private Text win_lbl;
    @FXML
    void initialize() { ok_btn.setOnAction(actionEvent -> {
        ok_btn.getScene().getWindow().hide(); });
    }
    void setup(String player) {
        String str = player + "\nwin!";
        win_lbl.setText(str); }
}