package com.company;

public class DigitalClockImpl implements DigitalClock {
    private Integer hours;
    private Integer minutes;

    DigitalClockImpl(Integer hours, Integer minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }
    @Override
    public void showTime() {
        if (minutes >= 10) {
            System.out.println("Текущее время: " + hours.toString() + ":" + minutes.toString());
        }
        else {
            System.out.println(hours.toString() + ":0" + minutes.toString());
        }
    }
}
