package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;


public class Game {

    private Service<String> service;

    Connection connection;

    int player;

    public Game() {
        score.set("20");
        connection = new Connection();
    }

    private StringProperty score = new SimpleStringProperty();

    public final String getScore() {
        return score.get();
    }

    public final void setScore(String str) {
        score.set(str);
    }

    public StringProperty scoreProperty() {
        return score;
    }

    private StringProperty message = new SimpleStringProperty();

    public final String getMessage() {
        return message.get();
    }

    public final void setMessage(String str) {
        message.set(str);
    }

    public StringProperty messageProperty() {
        return message;
    }

    public int startGame() {

        player = Integer.parseInt(connection.getMessage());
        if (player == 0) {
            return 0;
        }
        return 1;
    }

    public void step(int i) {
        connection.sendMessage(String.valueOf(i));
    }

    public boolean isWinner(int i) {
        if (i <= 0) {
            return false;
        }
        return true;
    }
}
