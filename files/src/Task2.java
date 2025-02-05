import java.io.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();

        String longestLine = "";
        int maxLength = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null) {
                if (line.length() > maxLength) {
                    maxLength = line.length();
                    longestLine = line;
                }
            }
            System.out.println("Довжина найдовшого рядка: " + maxLength);
            System.out.println("Найдовший рядок: " + longestLine);

        } catch (IOException e) {
            System.out.println("Помилка читання файлу:");
            e.printStackTrace();
        }
    }
}
