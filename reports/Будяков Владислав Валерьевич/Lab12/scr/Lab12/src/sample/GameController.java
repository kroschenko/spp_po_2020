package sample;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.*;
import java.io.*;
public class GameController {
    @FXML
private Button btn10;
    @FXML
private Button btn20;
    @FXML
private Button btn14;
    @FXML
private Button btn13;
    @FXML
private Button btn12;
    @FXML
private Button btn11;
    @FXML
private Text player_lbl;
    @FXML
private Text count_lbl;
    @FXML
private Button btn8;
    @FXML
private Button btn9;
    @FXML
private Button btn6;
    @FXML
private Button btn7;
    @FXML
private Button btn4;
    @FXML
private Button btn5;
    @FXML
private Button btn2;
    @FXML
private Button btn18;
    @FXML
private Button btn3;
    @FXML
private Button btn17;
    @FXML
private Button btn16;
    @FXML
private Button next_btn;
    @FXML
private Button btn1;
    @FXML
private Button btn15;
    @FXML
private Button btn19;
    @FXML
    void initialize() throws IOException { next_btn.setOnAction(actionEvent -> {
        onNext();
    });
        Button[] btnArray = new Button[20]; btnArray[0] = btn1;
        btnArray[1] = btn2;
        btnArray[2] = btn3;
        btnArray[3] = btn4; btnArray[4] = btn5; btnArray[5] = btn6; btnArray[6] = btn7; btnArray[7] = btn8; btnArray[8] = btn9; btnArray[9] = btn10; btnArray[10] = btn11; btnArray[11] = btn12; btnArray[12] = btn13; btnArray[13] = btn14; btnArray[14] = btn15; btnArray[15] = btn16; btnArray[16] = btn17; btnArray[17] = btn18; btnArray[18] = btn19; btnArray[19] = btn20;
        for(Button b : btnArray) { b.setOnAction(actionEvent -> {
            if (counter < maxCount) { b.setVisible(false);
                counter++;
                size--;
                count_lbl.setText("Count: " + counter); if (size == 0) {
                    String winner = (currentPlayer == firstPlayer) ? secondPlayer : firstPlayer;
                    finish(winner); }
            } else {
                onNext(); }

        }); }
        getDataFromServer(); }
    private String firstPlayer; private String secondPlayer; private int size = 20; private int counter = 0; private String currentPlayer; private int maxCount = 0;
    void onNext() { counter = 0;
        count_lbl.setText("Count: 0");
        currentPlayer = (currentPlayer == firstPlayer) ? secondPlayer : firstPlayer;
        player_lbl.setText(currentPlayer); }
    void setup(String firstPlayer, String secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.currentPlayer = firstPlayer;
        player_lbl.setText(currentPlayer);
    }
    void finish(String player) {
        FXMLLoader loader = new FXMLLoader(); loader.setLocation(getClass().getResource("Finish.fxml"));
        try { loader.load();
        } catch (IOException e) {
            e.printStackTrace(); }
        Parent root = loader.getRoot();
        FinishController finish = loader.getController(); finish.setup(player);
        Stage stage = new Stage();
        stage.setScene(new Scene(root)); stage.showAndWait();
    }
    void getDataFromServer() throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8000); BufferedReader reader = new BufferedReader(new
                InputStreamReader(clientSocket.getInputStream())); String message = reader.readLine(); maxCount = Integer.parseInt(message); System.out.println(message); clientSocket.close();
    }
}