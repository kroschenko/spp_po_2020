package sample;

public class Calculator extends Thread{
    private final Controller controller;
    private double X;
    private int N;

    public Calculator(int X, int N, Controller controller) {
        this.X = X;
        this.N = N;
        this.controller = controller;
    }

    @Override
    public void run() {
        double a = 1.0D;
        double sum = a;

        try {
            for (int i = 1, k = 1; i  < N && !isInterrupted(); ++i, ++k) {
                controller.updateResult(sum);
                a = (a * X * X) / (double) (k * (k + 1));
                sum += a;

                Thread.sleep(500);
            }
            controller.updateResult(sum);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        controller.reinitialize();
    }
}
