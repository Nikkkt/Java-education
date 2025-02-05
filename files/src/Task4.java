import java.io.*;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();

        System.out.println("Введіть елементи масиву (через пробіл):");
        String inputLine = scanner.nextLine();
        String[] parts = inputLine.split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);

        StringBuilder original = new StringBuilder();
        StringBuilder evens = new StringBuilder();
        StringBuilder odds = new StringBuilder();
        StringBuilder reversed = new StringBuilder();

        for (int num : arr) {
            original.append(num).append(" ");
            if (num % 2 == 0) evens.append(num).append(" ");
            else odds.append(num).append(" ");
        }
        for (int i = arr.length - 1; i >= 0; i--) reversed.append(arr[i]).append(" ");

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(original.toString().trim());
            writer.println(evens.toString().trim());
            writer.println(odds.toString().trim());
            writer.println(reversed.toString().trim());
        } catch (IOException e) {
            System.out.println("Помилка запису у файл:");
            e.printStackTrace();
        }

        System.out.println("Дані успішно збережено у файл.");
    }
}
