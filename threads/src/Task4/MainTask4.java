package Task4;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class MainTask4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до директорії: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Введіть слово для пошуку: ");
        String searchWord = scanner.nextLine();

        File directory = new File(directoryPath);
        CountDownLatch mergerDoneLatch = new CountDownLatch(1);

        FileMerger merger = new FileMerger(directory, searchWord, mergerDoneLatch);
        Thread mergerThread = new Thread(merger);

        ForbiddenWordRemover remover = new ForbiddenWordRemover(mergerDoneLatch);
        Thread removerThread = new Thread(remover);

        mergerThread.start();
        removerThread.start();

        try {
            mergerThread.join();
            removerThread.join();
        }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        System.out.println("Операції завершено.");
        System.out.println("Кількість файлів, з яких було злиття: " + merger.getFilesMergedCount());
        System.out.println("Кількість видалених заборонених слів: " + remover.getForbiddenWordsRemovedCount());
    }
}
