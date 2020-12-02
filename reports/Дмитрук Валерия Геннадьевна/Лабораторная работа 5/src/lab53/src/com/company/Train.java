package com.company;


import java.time.LocalDateTime;

import java.util.ArrayList;


public class Train {
    private LocalDateTime dayAndTime;
    private Integer number;
    final private Integer seatsAmount;
    private Integer occupiedSeatsAmount;
    private final ArrayList<String> stations;
    private Float pricePerSeat;

    public Train(
            LocalDateTime dayAndTime,
            Integer number,
            Integer seatsAmount,
            ArrayList<String> stations,
            Float pricePerSeat
            ) {
        this.dayAndTime = dayAndTime;
        this.number = number;
        this.seatsAmount = seatsAmount;
        this.occupiedSeatsAmount = 0;
        this.stations = stations;
        this.pricePerSeat = pricePerSeat;
    }

    public Float getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(Float pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    public LocalDateTime getDayAndTime() {
        return dayAndTime;
    }

    public void setDayAndTime(LocalDateTime dayAndTime) {
        this.dayAndTime = dayAndTime;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ArrayList<String> getStations() {
        return stations;
    }

    public Integer getSeatsAmount() {
        return seatsAmount;
    }

    public Integer getOccupiedSeatsAmount() {
        return occupiedSeatsAmount;
    }

    public void reserveSeat(){
        this.occupiedSeatsAmount++;
    }

    public boolean hasFreeSeats() {
        return occupiedSeatsAmount < seatsAmount;
    }

    @Override
    public String toString() {
        return "Train{" +
                "dayAndTime=" + dayAndTime +
                ", number=" + number +
                ", seatsAmount=" + seatsAmount +
                ", occupiedSeatsAmount=" + occupiedSeatsAmount + ", pricePerSeat=" + pricePerSeat + '}';
    }
}
