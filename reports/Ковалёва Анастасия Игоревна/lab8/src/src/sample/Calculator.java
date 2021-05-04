package sample;

import static java.lang.Math.pow;

public class Calculator extends Thread {

    private int N;
    private int X;
    private final Controller controller;

    public Calculator( int N, int X, Controller controller) { this.N = N;
        this.X = X;
        this.controller = controller; }
    @Override
    public void run() {
        double a = 1.;
        double sum = a;
        int i = 1;
        try {
            while (i < N && !isInterrupted()) {
                controller.updateResult(sum);
                a = a * ((double) X / i);
                sum += a;
                i++;
                synchronized (controller) {
                    controller.updateResult(sum);
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
