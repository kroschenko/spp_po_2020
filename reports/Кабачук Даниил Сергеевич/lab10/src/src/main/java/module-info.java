module labaTen {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;

    opens sample;
    opens sample.controller;
    opens sample.model;
}