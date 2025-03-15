package Task1;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class MainTask1 {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 10;
        int[] array = new int[SIZE];

        CountDownLatch arrayFilledLatch = new CountDownLatch(1);

        ArrayFiller filler = new ArrayFiller(array, arrayFilledLatch);
        Thread fillerThread = new Thread(filler);

        SumCalculator sumCalc = new SumCalculator(array, arrayFilledLatch);
        Thread sumThread = new Thread(sumCalc);

        AverageCalculator avgCalc = new AverageCalculator(array, arrayFilledLatch);
        Thread avgThread = new Thread(avgCalc);

        fillerThread.start();
        sumThread.start();
        avgThread.start();

        fillerThread.join();
        sumThread.join();
        avgThread.join();

        System.out.println("Масив: " + Arrays.toString(array));
        System.out.println("Сума: " + sumCalc.getSum());
        System.out.println("Середнє: " + avgCalc.getAverage());
    }
}
