package com.company;

public class Main {

    public static void main(String[] args) {
        DigitalClock digitalTime = new AnalogClockAdapter(new AnalogClock(300, 180));
        digitalTime.showTime();
    }
}
