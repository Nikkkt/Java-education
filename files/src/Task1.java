import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до першого файлу: ");
        String file1Path = scanner.nextLine();

        System.out.print("Введіть шлях до другого файлу: ");
        String file2Path = scanner.nextLine();

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(file1Path));
                BufferedReader br2 = new BufferedReader(new FileReader(file2Path))
        ) {
            int lineNumber = 1;
            boolean allMatch = true;
            while (true) {
                String line1 = br1.readLine();
                String line2 = br2.readLine();

                if (line1 == null && line2 == null) break;

                if (line1 == null) line1 = "";
                if (line2 == null) line2 = "";

                if (!line1.equals(line2)) {
                    allMatch = false;
                    System.out.println("Рядок " + lineNumber + " не збігається:");
                    System.out.println("Файл 1: " + line1);
                    System.out.println("Файл 2: " + line2);
                }
                lineNumber++;
            }
            if (allMatch) System.out.println("Усі рядки збігаються.");

        } catch (IOException e) {
            System.out.println("Сталася помилка при роботі з файлами:");
            e.printStackTrace();
        }
    }
}
