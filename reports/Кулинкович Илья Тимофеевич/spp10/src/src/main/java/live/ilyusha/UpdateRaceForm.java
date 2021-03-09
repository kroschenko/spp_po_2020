package live.ilyusha;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateRaceForm extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public Race race;

    public UpdateRaceForm(Race updateRace) {
        this.race = updateRace;
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {
        List<Location> locations = new ArrayList<>();
        List<Racer> racers = new ArrayList<>();
        List<String> locationsNames = new ArrayList<>();
        List<String> racersNames = new ArrayList<>();
        DBProcess db = new DBProcess();
        ResultSet locationsResult = db.select("select * from race_location");
        while (locationsResult.next()) {
            locations.add(new Location(locationsResult.getInt("race_location_id"), locationsResult.getString("name"), locationsResult.getString("country")));
        }
        ResultSet racersResult = db.select("select racer.racer_id as racerId, racer.name as racerName, racer.birth_year as racerBirthYear, car.make as carMake, car.name as carName from racer inner join car on racer.car_id = car.car_id");
        while (racersResult.next()) {
            racers.add(new Racer(
                    racersResult.getInt("racerId"),
                    racersResult.getString("racerName"),
                    racersResult.getInt("racerBirthYear"),
                    new Car(
                            racersResult.getString("carMake"),
                            racersResult.getString("carName")
                    )
            ));
        }
        for (Location location : locations) {
            locationsNames.add(location.name);
        }
        for (Racer racer : racers) {
            racersNames.add(racer.name);
        }
        ObservableList<String> locationsList = FXCollections.observableArrayList(locationsNames);
        ObservableList<String> racersList = FXCollections.observableArrayList(racersNames);
        final ComboBox<String> updateLocation = new ComboBox<String>(locationsList);
        updateLocation.setMinWidth(250);
        updateLocation.setMaxWidth(250);
        updateLocation.setValue(race.location.name);
        final ComboBox<String> updateRacer = new ComboBox<String>(racersList);
        updateRacer.setMinWidth(250);
        updateRacer.setMaxWidth(250);
        updateRacer.setValue(race.winner.name);
        final Button updateButton = new Button("Update");
        updateButton.setMinWidth(250);
        updateButton.setMaxWidth(250);
        updateButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        try {
                            String locationName = updateLocation.getValue();
                            String racerName = updateRacer.getValue();
                            Integer locationId = locations.stream().filter(x -> x.name == locationName).findAny().map(x -> x.id).orElse(0);
                            Integer racerId = racers.stream().filter(x -> x.name == racerName).findAny().map(x -> x.id).orElse(0);
                            db.update("update race set " +
                                    "winner_id = " + racerId + ", race_location_id = " + locationId + " where " +
                                    "race_id = " + race.id);
                            primaryStage.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(updateLocation, updateRacer, updateButton);
        primaryStage.setTitle("Update Race");
        Scene scene = new Scene(root, 270, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
