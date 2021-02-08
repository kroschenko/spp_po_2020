package sample;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.geometry.Pos;


public class Main extends Application {
    private Button stopThread;
    private Button resumeThread;
    private Button interruptThread;
    private Button calculate;
    private VBox threadControlsSection;
    private VBox calculationControlsSection;
    private TextField serialNumberInput;
    private Scene scene;
    private Label threadButtonsInfo;
    private FlowPane root;
    private Label calculationOutput;

    private ThreadManager thread;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        thread = new ThreadManager();

        root = createUiRoot();
        scene = new Scene(root);

        configureStage(stage);
        stage.show();
    }

    private FlowPane createUiRoot() {
        calculationControlsSection = createCalculationControlSection();
        threadControlsSection = createThreadControlSection();

        FlowPane result = new FlowPane(calculationControlsSection, threadControlsSection);
        result.setAlignment(Pos.CENTER);
        result.setOrientation(Orientation.HORIZONTAL);
        result.setVgap(10);
        result.setHgap(10);

        return result;
    }

    private void configureStage(Stage stage) {
        stage.setScene(scene);
        stage.setMinHeight(400);
        stage.setMinWidth(500);
    }

    private VBox createThreadControlSection() {
        threadButtonsInfo = new Label("Buttons for thread manipulating");

        stopThread = new Button("Stop");
        stopThread.setPrefWidth(80);
        stopThread.setOnAction(event -> {
            thread.stop();

            stopThread.setDisable(true);
            resumeThread.setDisable(false);
        });

        resumeThread = new Button("Resume");
        resumeThread.setPrefWidth(80);
        resumeThread.setOnAction(event -> {
            thread.resume();

            stopThread.setDisable(false);
            resumeThread.setDisable(true);
        });

        interruptThread = new Button("Discard");
        interruptThread.setPrefWidth(80);
        interruptThread.setOnAction(event -> {
            thread.interrupt();

            stopThread.setDisable(true);
            resumeThread.setDisable(true);
        });

        return new VBox(5, threadButtonsInfo, stopThread, resumeThread, interruptThread);
    }

    private VBox createCalculationControlSection() {
        serialNumberInput = new TextField();
        serialNumberInput.setPrefColumnCount(10);

        calculationOutput = new Label();

        calculate = new Button("Calculate");
        calculate.setPrefWidth(80);
        calculate.setOnAction(event -> {
            SeriesCalculator seriesCalculator = new SeriesCalculator(Integer.parseInt(serialNumberInput.getText()));
            thread.setCalculator(seriesCalculator);
            calculationOutput.textProperty().bind(seriesCalculator.messageProperty());

            thread.start();

            stopThread.setDisable(false);
            resumeThread.setDisable(false);
            interruptThread.setDisable(false);

        });


        return new VBox(5, serialNumberInput, calculate, calculationOutput);
    }
}