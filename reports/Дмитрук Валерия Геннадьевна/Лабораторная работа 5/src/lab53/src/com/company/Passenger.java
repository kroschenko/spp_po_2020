package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Passenger implements Person {
    @Override
    public void sayHello() {
        System.out.println("Hello! I'm a passenger. I'm looking for a train.");
    }
        public Request createRequest(String destination, String date)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            Request request = new Request();
            request.setDayAndTime(LocalDateTime.parse(date, formatter));
            request.setDestination(destination);
            return request;
        }
        public Bill chooseTrain(ArrayList<Train> trains) {
        Scanner scanner = new Scanner(System.in);
        for (Train train : trains) {
            System.out.println(train);
        }
        System.out.println("Choose a train number: ");
        Integer chosenNumber = scanner.nextInt();
        boolean trainIsNotFound = true;
        Train chosenTrain = null;
        for (int i = 0; i < trains.size() && trainIsNotFound; i++) {
            if (trains.get(i).getNumber().equals(chosenNumber)) {
                chosenTrain = trains.get(i);
                chosenTrain.reserveSeat();
                 trainIsNotFound = false;
             }
        }
        if (chosenTrain != null) {
        Bill bill = new Bill();
        bill.setPrice(chosenTrain.getPricePerSeat());
        bill.setSeatNumber(chosenTrain.getOccupiedSeatsAmount());
        return bill;
        } else {
            throw new RuntimeException("Train is not found!");
         }
    }
}
