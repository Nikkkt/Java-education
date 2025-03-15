package Task1;

import java.util.concurrent.CountDownLatch;

public class AverageCalculator implements Runnable {
    private int[] array;
    private CountDownLatch latch;
    private double average;

    public AverageCalculator(int[] array, CountDownLatch latch) {
        this.array = array;
        this.latch = latch;
    }

    @Override
    public void run() {
        try { latch.await(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        int sum = 0;

        for (int num : array) sum += num;
        if (array.length > 0) average = (double) sum / array.length;
    }

    public double getAverage() { return average; }
}
