package sample;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class View {

    private Service<String> service;
    @FXML
    Label label;

    @FXML
    private Label messageLabel;
    @FXML
    private Button threeButton;

    @FXML
    private Button startButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button stopButton;

    @FXML
    private Button oneButton;

    @FXML
    Game game;

    void displayStart() {
        startButton.setDisable(true);
        game.setScore("20");
        game.startGame();

        if (game.player == 0) {
            game.setMessage("You are " + (game.player + 1) + " player. Your step");

        }

        if (game.player == 1) {
            setDisableStepButton(true);
            game.setMessage("You are " + (game.player + 1) + " player. Wait your step");
            // ожидаем хода перврго игрока
            waitAnswer();
        }
    }

    void displayStep(int step) {
        setDisableStepButton(true);
        game.setMessage("Wait your step");

        int i = Integer.parseInt(game.getScore()) - step;
        game.setScore(String.valueOf(i));

        service = new Service<String>() {
            @Override
            protected Task<String> createTask() {
                return new Task<String>() {
                    @Override
                    protected String call() throws Exception {
                        String s = "";
                        game.step(i);
                        if(game.isWinner(i)){
                            s = game.connection.getMessage();
                            return s;
                        }else {
                            s = "You win";
                            return s;
                        }
                    }
                };
            }
        };
        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

            @Override
            public void handle(WorkerStateEvent event) {
                setDisableStepButton(false);
                game.setMessage("your step");
                game.setScore(service.getValue());
            }
        });

        service.start();
    }
    void waitAnswer() {

        service = new Service<String>() {
            @Override
            protected Task<String> createTask() {
                return new Task<String>() {
                    @Override
                    protected String call() throws Exception {
                        String s = game.connection.getMessage();
                        return s;
                    }
                };
            }
        };
        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

            @Override
            public void handle(WorkerStateEvent event) {
                setDisableStepButton(false);
                game.setMessage("Your step");
                game.setScore(service.getValue());
            }
        });

        service.start();
    }

    void setDisableStepButton(Boolean flag) {
        oneButton.setDisable(flag);
        twoButton.setDisable(flag);
        threeButton.setDisable(flag);
    }
}
