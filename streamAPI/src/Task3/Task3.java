package Task3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        List<Device> devices = Arrays.asList(
                new Device("Смартфон", 2022, 1000.0, "Чорний", "Електроніка"),
                new Device("Ноутбук", 2021, 1500.0, "Срібний", "Комп'ютери"),
                new Device("Планшет", 2023, 800.0, "Білий", "Електроніка"),
                new Device("Телевізор", 2020, 1200.0, "Чорний", "Бытова техніка"),
                new Device("Камера", 2022, 600.0, "Чорний", "Фото"),
                new Device("Розумний годинник", 2023, 300.0, "Чорний", "Гаджети")
        );

        System.out.println("Всі пристрої:");
        devices.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведіть колір пристрою для фільтрації: ");
        String color = scanner.nextLine();
        System.out.println("Пристрої з кольором '" + color + "':");
        devices.stream()
               .filter(d -> d.getColor().equalsIgnoreCase(color))
               .forEach(System.out::println);

        System.out.print("\nВведіть рік випуску для фільтрації: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Пристрої, випущені в " + year + ":");
        devices.stream()
               .filter(d -> d.getYear() == year)
               .forEach(System.out::println);

        System.out.print("\nВведіть мінімальну ціну для фільтрації: ");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Пристрої, дорожчі за " + minPrice + ":");
        devices.stream()
               .filter(d -> d.getPrice() > minPrice)
               .forEach(System.out::println);

        System.out.print("\nВведіть тип пристрою для фільтрації: ");
        String type = scanner.nextLine();
        System.out.println("Пристрої типу '" + type + "':");
        devices.stream()
               .filter(d -> d.getType().equalsIgnoreCase(type))
               .forEach(System.out::println);

        System.out.print("\nВведіть початковий рік діапазону: ");
        int startYear = scanner.nextInt();
        System.out.print("Введіть кінцевий рік діапазону: ");
        int endYear = scanner.nextInt();
        System.out.println("Пристрої, випущені між " + startYear + " та " + endYear + ":");
        devices.stream()
               .filter(d -> d.getYear() >= startYear && d.getYear() <= endYear)
               .forEach(System.out::println);

        scanner.close();
    }
}
