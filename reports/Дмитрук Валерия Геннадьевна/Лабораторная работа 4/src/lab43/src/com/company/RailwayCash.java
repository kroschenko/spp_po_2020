package com.company;
import java.util.ArrayList;
import java.util.Collections;

public class RailwayCash {
    private ArrayList<Train> trainsList;

    public RailwayCash() {
        this.trainsList = new ArrayList<>();
    }

    public void addTrains(Train... trains) {
        Collections.addAll(trainsList, trains);
    }

    public ArrayList<Train> findTrainsByRequest(Request request) {
        ArrayList<Train> suitableTrains = new ArrayList<>();
        for (Train train : trainsList) {
            if (train.getDayAndTime().isEqual(request.getDayAndTime())
                    &&	train.getStations().contains(request.getDestination())
                    &&	train.hasFreeSeats()) {
                suitableTrains.add(train);
            }
        }
        return suitableTrains;
    }
}
