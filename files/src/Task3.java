import java.io.*;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();

        int totalSum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int arrayCount = 1;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("\\s+");
                int[] numbers = new int[parts.length];

                int sum = 0;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int i = 0; i < parts.length; i++) {
                    int num = Integer.parseInt(parts[i]);
                    numbers[i] = num;
                    sum += num;

                    if (num < min) min = num;
                    if (num > max) max = num;
                }
                totalSum += sum;

                System.out.println("Масив " + arrayCount + ": " + Arrays.toString(numbers));
                System.out.println("Максимум: " + max + ", Мінімум: " + min + ", Сума: " + sum);
                System.out.println();
                arrayCount++;
            }
            System.out.println("Загальна сума усіх елементів: " + totalSum);

        } catch (IOException e) {
            System.out.println("Помилка роботи з файлом:");
            e.printStackTrace();
        }
    }
}
