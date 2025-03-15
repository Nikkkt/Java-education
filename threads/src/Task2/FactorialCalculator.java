package Task2;

import java.io.*;
import java.math.BigInteger;
import java.util.concurrent.CountDownLatch;

public class FactorialCalculator implements Runnable {
    private File file;
    private CountDownLatch latch;
    private int factorialCount;

    public FactorialCalculator(File file, CountDownLatch latch) {
        this.file = file;
        this.latch = latch;
    }

    private BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    @Override
    public void run() {
        try { latch.await(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        File outFile = new File("factorials.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                BigInteger fact = factorial(num);
                writer.write(num + "! = " + fact);
                writer.newLine();
                factorialCount++;
            }
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public int getFactorialCount() { return factorialCount; }
}
