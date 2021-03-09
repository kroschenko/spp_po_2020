package sample;
import javafx.concurrent.Task;

public class SeriesCalculator extends Task {

    private int seriesNumber;

    public volatile boolean isStop;

    SeriesCalculator(int seriesNumber)
    {
        this.seriesNumber = seriesNumber;
    }

    @Override
    protected Object call() {
        try {
            double current = 0, prev = 1, sum = 1;
            for (int i = 1; i <= seriesNumber; i++) {
                while (isStop) { }

                current = prev*(-1/(double)i);
                prev = current;
                sum += current;

                updateMessage("iteration: " + i + " value: " + sum);

                Thread.sleep(100);
            }
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
