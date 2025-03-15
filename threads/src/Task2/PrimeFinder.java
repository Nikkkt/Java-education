package Task2;

import java.io.*;
import java.util.concurrent.CountDownLatch;

public class PrimeFinder implements Runnable {
    private File file;
    private CountDownLatch latch;
    private int primeCount;

    public PrimeFinder(File file, CountDownLatch latch) {
        this.file = file;
        this.latch = latch;
    }

    private boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) if(n % i == 0) return false;
        return true;
    }

    @Override
    public void run() {
        try { latch.await(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        File outFile = new File("primes.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            String line;
            while((line = reader.readLine()) != null){
                int num = Integer.parseInt(line);
                if(isPrime(num)){
                    writer.write(String.valueOf(num));
                    writer.newLine();
                    primeCount++;
                }
            }
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public int getPrimeCount() { return primeCount; }
}
