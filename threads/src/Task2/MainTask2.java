package Task2;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class MainTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        File file = new File(filePath);

        CountDownLatch fileFilledLatch = new CountDownLatch(1);

        FileFiller fileFiller = new FileFiller(file, fileFilledLatch);
        Thread fillerThread = new Thread(fileFiller);
        fillerThread.start();

        PrimeFinder primeFinder = new PrimeFinder(file, fileFilledLatch);
        Thread primeThread = new Thread(primeFinder);

        FactorialCalculator factorialCalculator = new FactorialCalculator(file, fileFilledLatch);
        Thread factorialThread = new Thread(factorialCalculator);

        primeThread.start();
        factorialThread.start();

        try {
            fillerThread.join();
            primeThread.join();
            factorialThread.join();
        }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        System.out.println("Статистика:");
        System.out.println("Кількість чисел записаних у файл: " + fileFiller.getNumbersWritten());
        System.out.println("Кількість простих чисел: " + primeFinder.getPrimeCount());
        System.out.println("Обчислено факторіалів для " + factorialCalculator.getFactorialCount() + " чисел");
    }
}
