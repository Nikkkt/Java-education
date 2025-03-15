package Task1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ArrayFiller implements Runnable {
    private int[] array;
    private CountDownLatch latch;

    public ArrayFiller(int[] array, CountDownLatch latch) {
        this.array = array;
        this.latch = latch;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            try { Thread.sleep(50); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        latch.countDown();
    }
}
