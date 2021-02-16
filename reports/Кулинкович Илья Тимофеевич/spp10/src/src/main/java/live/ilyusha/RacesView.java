package live.ilyusha;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RacesView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {
        DBProcess db = new DBProcess();
        ResultSet racesResult = db.select("select " +
                "race.race_id as raceId, racer.racer_id as racerId, racer.name as racerName, racer.birth_year as racerBirthYear, " +
                "race_location.race_location_id as locationId, race_location.name as locationName, race_location.country as locationCountry, " +
                "car.make as carMake, car.name as carName from race " +
                "inner join racer on race.winner_id = racer.racer_id " +
                "inner join car on racer.car_id = car.car_id " +
                "inner join race_location on race.race_location_id = race_location.race_location_id");

        List<Race> races = new ArrayList<>();
        while (racesResult.next()) {
            races.add(new Race(
                racesResult.getInt("raceId"),
                new Racer(racesResult.getInt("racerId"), racesResult.getString("racerName"), racesResult.getInt("racerBirthYear"), new Car(
                    racesResult.getString("carMake"), racesResult.getString("carName")
                )),
                new Location(racesResult.getInt("locationId"), racesResult.getString("locationName"), racesResult.getString("locationCountry"))
            ));
        }
        ObservableList<Race> racesList = FXCollections.observableArrayList(races);
        TableView<Race> table = new TableView<Race>(racesList);
        table.setMinWidth(480);
        table.setEditable(false);

        TableColumn<Race, Integer> columnId = new TableColumn<Race, Integer>("Race ID");
        columnId.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Race, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Race, Integer> param) {
                return new SimpleObjectProperty<Integer>(param.getValue().id);
            }
        });

        TableColumn<Race, String> columnWinner = new TableColumn<Race, String>("Race winner name");
        columnWinner.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Race, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Race, String> param) {
                return new SimpleObjectProperty<String>(param.getValue().winner.name);
            }
        });

        TableColumn<Race, String> columnWinnerCar = new TableColumn<Race, String>("Race winner's car");
        columnWinnerCar.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Race, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Race, String> param) {
                return new SimpleObjectProperty<String>(param.getValue().winner.car.make + " " + param.getValue().winner.car.name);
            }
        });
// Coach column
        TableColumn<Race, String> columnLocation = new TableColumn<Race, String>("Race location");
        columnLocation.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Race, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Race, String> param) {
                return new SimpleObjectProperty<String>(param.getValue().location.name + ", " + param.getValue().location.country);
            }
        });
        table.getColumns().addAll(columnId, columnWinner, columnWinnerCar, columnLocation);
// отслеживание выделенной строки
        final Race[] race = new Race[1];
        TableView.TableViewSelectionModel<Race> selectionModel = table.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Race>() {
            @Override
            public void changed(ObservableValue<? extends Race> observableValue, Race oldRace, Race
                    newRace) {
                if (newRace != null) {
                    race[0] = newRace;
                }
            }
        });
        Stage updateStage = new Stage();
        final Button updateButton = new Button("Update");
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    updateStage.close();
                    UpdateRaceForm updateRace = new UpdateRaceForm(race[0]);
                    updateRace.start(updateStage);
                } catch (NullPointerException | SQLException e) {
                    try {
                        start(primaryStage);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        Stage addStage = new Stage();
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    addStage.close();
                    AddRaceForm addRace = new AddRaceForm();
                    addRace.start(addStage);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    Race selectedItem = table.getSelectionModel().getSelectedItem();
                    try {
                        db.delete("delete from race where race_id == " + selectedItem.id);
                        start(primaryStage);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        final Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    start(primaryStage);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        FilteredList<Race> filteredData = new FilteredList<>(racesList, p -> true);
        final TextField winnerFilter = new TextField();
        winnerFilter.setPromptText("Winner filter");
        winnerFilter.setMinWidth(250);
        winnerFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(currentRace -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return currentRace.winner.name.toLowerCase().contains(newValue);
            });
        });
        SortedList<Race> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
        VBox root = new VBox();
        HBox deleteBox = new HBox();
        HBox addBox = new HBox();
        root.setPadding(new Insets(5));
        root.setSpacing(10);
        root.getChildren().addAll(deleteBox, table, addBox);
        deleteBox.setPadding(new Insets(5));
        deleteBox.setSpacing(10);
        deleteBox.getChildren().addAll(deleteButton, refreshButton);
        addBox.setPadding(new Insets(5));
        addBox.setSpacing(10);
        addBox.getChildren().addAll(winnerFilter, addButton, updateButton);
        primaryStage.setTitle("Races Table");
        Scene scene = new Scene(root, 550, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}