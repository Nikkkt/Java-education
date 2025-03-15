package Task1;

import java.util.concurrent.CountDownLatch;

public class SumCalculator implements Runnable {
    private int[] array;
    private CountDownLatch latch;
    private int sum;

    public SumCalculator(int[] array, CountDownLatch latch) {
        this.array = array;
        this.latch = latch;
    }

    @Override
    public void run() {
        try { latch.await(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        for (int num : array) sum += num;
    }

    public int getSum() { return sum; }
}
