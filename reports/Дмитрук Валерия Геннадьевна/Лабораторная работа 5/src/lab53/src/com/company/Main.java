package com.company;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        RailwayCash railwayCash = new RailwayCash();
        Admin admin = new Admin(railwayCash);
        admin.sayHello();
        admin.addTrain(
                "2019-10-21 14:00",
                701,
                500,
                new ArrayList<String>(Arrays.asList("Жабинка", "Берёза", "Барановичи", "Минск")),
                13.50f
                );
        admin.addTrain(
                "2019-10-21 14:00",
                703,
                500,
                new ArrayList<String>(Arrays.asList("Барановичи", "Минск" )),
                15.50f
        );
        Passenger passenger = new Passenger();
        passenger.sayHello();
        Request request = passenger.createRequest(
                "Барановичи",
                "2019-10-21 14:00");
        Bill bill = passenger.chooseTrain(railwayCash.findTrainsByRequest(request));
        System.out.println(bill);
    }
}
