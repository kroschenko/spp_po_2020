package com.company;

public class AnalogClock {
    private Integer hourDegrees;
    private Integer minuteDegrees;
    AnalogClock(Integer hoursDegrees, Integer minutesDegrees) {
        this.hourDegrees = hoursDegrees;
        this.minuteDegrees = minutesDegrees;
    }
    public Integer getHourDegrees() {
        return hourDegrees;
    }
    public Integer getMinuteDegrees() {
        return minuteDegrees;
    }
}
