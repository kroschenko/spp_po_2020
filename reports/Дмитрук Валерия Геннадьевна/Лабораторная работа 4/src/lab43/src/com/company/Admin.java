package com.company;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Admin {
    private RailwayCash railwayCash;

    public Admin(RailwayCash railwayCash) {
        this.railwayCash = railwayCash;
    }

    public void addTrain(
            String dayAndTime,
            Integer number,
            Integer seatsAmount,
            ArrayList<String> stations,
            Float pricePerSeat
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Train train = new Train(
                LocalDateTime.parse(dayAndTime, formatter),
                number,
                seatsAmount,
                stations,
                pricePerSeat
        );
        railwayCash.addTrains(train);
    }
}
