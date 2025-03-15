package Task2;

import java.io.*;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class FileFiller implements Runnable {
    private File file;
    private CountDownLatch latch;
    private int numbersWritten;

    public FileFiller(File file, CountDownLatch latch) {
        this.file = file;
        this.latch = latch;
    }

    @Override
    public void run() {
        Random random = new Random();
        int count = 20;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < count; i++) {
                int number = random.nextInt(50) + 1;
                writer.write(String.valueOf(number));
                writer.newLine();
                numbersWritten++;
                Thread.sleep(50);
            }
        }
        catch (IOException | InterruptedException e) { e.printStackTrace(); }
        finally { latch.countDown(); }
    }

    public int getNumbersWritten() { return numbersWritten; }
}
