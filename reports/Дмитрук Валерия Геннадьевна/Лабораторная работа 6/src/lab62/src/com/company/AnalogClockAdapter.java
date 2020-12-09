package com.company;

public class AnalogClockAdapter implements DigitalClock{
    private AnalogClock analogClock;
    AnalogClockAdapter(AnalogClock analogClock) {
        this.analogClock = analogClock;
    }
    @Override
    public void showTime() {
        if (analogClock.getHourDegrees() >= 30 && analogClock.getMinuteDegrees() != 360) {
            DigitalClock digitalClock = new DigitalClockImpl(
                    analogClock.getHourDegrees() / 30 ,
                    analogClock.getMinuteDegrees() / 6
            );
            digitalClock.showTime();
        } else if (analogClock.getMinuteDegrees() == 360) {
            DigitalClock digitalClock = new DigitalClockImpl(
                    analogClock.getHourDegrees() / 30 + 1,
                    0
            );
            digitalClock.showTime();
        } else {
            DigitalClock digitalClock = new DigitalClockImpl(
                    12,
                    analogClock.getMinuteDegrees() / 6
            );
            digitalClock.showTime();
        }
    }
}
