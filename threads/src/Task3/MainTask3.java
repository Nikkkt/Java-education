package Task3;

import java.io.File;
import java.util.Scanner;

public class MainTask3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до вихідної директорії: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Введіть шлях до нової директорії: ");
        String destPath = scanner.nextLine();

        File sourceDir = new File(sourcePath);
        File destDir = new File(destPath);

        DirectoryCopier copier = new DirectoryCopier(sourceDir, destDir);
        Thread copyThread = new Thread(copier);
        copyThread.start();

        try { copyThread.join(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        System.out.println("Операція копіювання завершена");
        System.out.println("Скопійовано директорій: " + copier.getDirCount());
        System.out.println("Скопійовано файлів: " + copier.getFileCount());
    }
}
