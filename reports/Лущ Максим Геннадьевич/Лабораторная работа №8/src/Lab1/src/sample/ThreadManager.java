package sample;

public class ThreadManager {
    private SeriesCalculator calculator;
    private Thread thread;

    public void start() {
        thread.start();
    }

    public void stop() {
        calculator.isStop = true;
    }

    public void resume() {
        calculator.isStop = false;
    }

    public void interrupt() {
        thread.interrupt();
    }

    public void setCalculator(SeriesCalculator calculator) {
        if (this.calculator != null) {
            interrupt();
        }

        this.calculator = calculator;
        thread = new Thread(calculator);
    }
}
