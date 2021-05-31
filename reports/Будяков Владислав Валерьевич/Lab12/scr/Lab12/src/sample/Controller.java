package sample;
import java.io.IOException; import java.net.URL;
import java.util.ResourceBundle; import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button; import javafx.scene.control.TextField; import javafx.stage.Stage;
public class Controller {
    @FXML
    private TextField first_player_field;
    @FXML
    private Button ok_btn;
    @FXML
    private TextField second_player_field;
    @FXML
    void initialize() { ok_btn.setOnAction(actionEvent -> {
        String firstPlayer = first_player_field.getText();
        String secondPlayer = second_player_field.getText();
        ok_btn.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Game.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        GameController game = loader.getController();
        game.setup(firstPlayer,secondPlayer);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    });
    }
}
