package com.company;
import java.time.LocalDateTime;

public class Request {
    private String destination;
    private LocalDateTime dayAndTime;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDayAndTime() {
        return dayAndTime;
    }

    public void setDayAndTime(LocalDateTime dayAndTime) {
        this.dayAndTime = dayAndTime;
    }
}
