package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    double currentValue = 0;
    private double prevElement=0;
    private double currentSum=1;
    private int N = 3;

    int currentIteration = 0;
    Text sum = new Text("");
    TextField inputCount = new TextField();
    TextField inputValue = new TextField();
    Thread backgroundThread;
    Button start = new Button();
    GridPane grid;

    @Override
    public void init() {
        start.setText("Start");
        Button pause = new Button();
        pause.setText("Pause");
        Button stop = new Button();
        stop.setText("Stop");
        start.setOnAction(actionEvent -> startCalculate());
        pause.setOnAction(actionEvent -> {
            start.setDisable(false);
            backgroundThread.suspend();
        });
        stop.setOnAction(actionEvent -> {
            start.setDisable(false);
            stopCalculate();
        });
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text text = new Text("Текущая сумма: ");
        grid.add(text, 0, 0, 1, 1);
        grid.add(sum, 1, 0, 1, 1);
        Label labelCount = new Label("N:");
        Label labelValue = new Label("X:");
        grid.add(labelCount, 0, 1, 1, 1);
        grid.add(inputCount, 1, 1, 1, 1);
        grid.add(labelValue, 0, 2, 1, 1);
        grid.add(inputValue, 1, 2, 1, 1);
        grid.add(start, 0, 3);
        grid.add(pause, 1, 3);
        grid.add(stop, 2, 3);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Function");
        Scene scene = new Scene(grid, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void startCalculate() {
        if (backgroundThread != null) {
            backgroundThread.resume();
        } else {
            Thread task = new Thread(() -> {
                try {
                    int i = 1;
                    int count = Integer.parseInt(inputCount.getText());
                    int xValue = Integer.parseInt(inputValue.getText());
                    start.setDisable(true);
                    while (i <= count) {
                        try {
                            prevElement = Math.pow(xValue * Math.log10(N), i) / factorial(i);
                            currentSum += prevElement;
                            sum.setText(String.valueOf(currentSum));
                            i++;
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    start.setDisable(false);
                } catch (NumberFormatException e) {
                    sum.setText("Error in input!!!");
                }
            });

            backgroundThread = new Thread(task);
            backgroundThread.setDaemon(true);
            backgroundThread.start();
        }
    }
    public double factorial(int number)
    {
        if(number==0||number==1)
            return 1;
        int sum=1;
        for(int i=2; i<=number; i++)
            sum*=i;
        return sum;
    }

    public void stopCalculate() {
        backgroundThread.stop();
        backgroundThread = null;
        this.currentValue = 0;

        this.sum.setText("");
        this.currentSum = 1;
        this.prevElement = 0;
        this.currentIteration = 0;
        inputCount.setText("");
        inputValue.setText("");
    }

    public static void main(String[] args) {
        launch(args);
    }
}