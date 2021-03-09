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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddRaceForm extends Application {
    public static void main(String[] args) {
        launch(args);
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
        final ComboBox<String> addLocation = new ComboBox<String>(locationsList);
        addLocation.setMinWidth(250);
        addLocation.setMaxWidth(250);
        addLocation.setValue("Choose a location");
        final ComboBox<String> addRacer = new ComboBox<String>(racersList);
        addRacer.setMinWidth(250);
        addRacer.setMaxWidth(250);
        addRacer.setValue("Choose the race winner");
        final Button addButton = new Button("Add");
        addButton.setMinWidth(250);
        addButton.setMaxWidth(250);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!addLocation.getValue().equals("Choose a location") &&
                        !addRacer.getValue().equals("Choose the race winner")) {
                    try {
                        String locationName = addLocation.getValue();
                        String racerName = addRacer.getValue();
                        Integer locationId = locations.stream().filter(x -> x.name == locationName).findAny().map(x -> x.id).orElse(0);
                        Integer racerId = racers.stream().filter(x -> x.name == racerName).findAny().map(x -> x.id).orElse(0);
                        db.insert("insert into race (winner_id, race_location_id)" +
                                "values (" + racerId + ", " + locationId + ")");
                        primaryStage.close();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(addLocation, addRacer, addButton);
        primaryStage.setTitle("Add Race");
        Scene scene = new Scene(root, 270, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}