package com.company;

import java.util.ArrayList;

public class Car {
    private String model;
    private Integer year;
    private ArrayList<Wheel> wheels;

    public Car(String model, Integer year) { this.model = model;
        this.year = year;
        this.wheels = new ArrayList<>();
    }

    public void ride() {
        if(isCorrectlyMade()){
            System.out.println("Ready to go!");
        } else {
            System.out.println("Something went wrong");
        }
    }

    public boolean isCorrectlyMade() {
        if (this.wheels == null ||	this.wheels.size() != 4) { return false;
        }
        boolean isCorrectlyMade = true;
        for (int i = 0; i < this.wheels.size() && isCorrectlyMade; i++) {
            for (int j = 0; j < this.wheels.size() && isCorrectlyMade; j++) {
                if (!wheels.get(i).equals(wheels.get(j))) { isCorrectlyMade = false;
                }
            }
        }
        return isCorrectlyMade;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public ArrayList<Wheel> getWheels() {
        return wheels;
    }

    public void addWheel(Integer wheelSize, String seasonType) {
        this.wheels.add(new Wheel(wheelSize, seasonType));
    }

    public class Wheel {
        private Integer wheelSize;
        private String seasonType;

        public Wheel(Integer wheelSize, String seasonType) {
            this.wheelSize = wheelSize;
            this.seasonType = seasonType;
        }

        public Integer getWheelSize() {
            return wheelSize;
        }

        public void setWheelSize(Integer wheelSize) {
            this.wheelSize = wheelSize;
        }

        public String getSeasonType() {
            return seasonType;
        }

        public void setSeasonType(String seasonType) {
            this.seasonType = seasonType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false; Wheel wheel = (Wheel) o;
            return wheelSize.equals(wheel.wheelSize) && seasonType.equals(wheel.seasonType);
        }
    }
}
