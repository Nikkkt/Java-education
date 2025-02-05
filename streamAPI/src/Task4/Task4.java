package Task4;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        List<Projector> projectors = Arrays.asList(
                new Projector("Проектор A", 2023, 500.0, "Sony"),
                new Projector("Проектор B", 2022, 750.0, "Samsung"),
                new Projector("Проектор C", 2023, 600.0, "Sony"),
                new Projector("Проектор D", 2021, 400.0, "LG"),
                new Projector("Проектор E", 2023, 800.0, "Samsung")
        );

        System.out.println("Всі проектори:");
        projectors.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведіть виробника для фільтрації проекторів: ");
        String manufacturer = scanner.nextLine();
        System.out.println("Проектори виробника '" + manufacturer + "':");
        projectors.stream()
                  .filter(p -> p.getManufacturer().equalsIgnoreCase(manufacturer))
                  .forEach(System.out::println);

        int currentYear = Calendar
                  .getInstance()
                  .get(Calendar.YEAR);
        System.out.println("\nПроектори поточного року (" + currentYear + "):");
        projectors.stream()
                  .filter(p -> p.getYear() == currentYear)
                  .forEach(System.out::println);

        System.out.print("\nВведіть мінімальну ціну для фільтрації проекторів: ");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Проектори з ціною вище " + minPrice + ":");
        projectors.stream()
                  .filter(p -> p.getPrice() > minPrice)
                  .forEach(System.out::println);

        System.out.println("\nПроектори, відсортовані за ціною (зростання):");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice))
                .forEach(System.out::println);

        System.out.println("\nПроектори, відсортовані за ціною (спадання):");
        projectors.stream()
                  .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                  .forEach(System.out::println);

        System.out.println("\nПроектори, відсортовані за роком випуску (зростання):");
        projectors.stream()
                  .sorted(Comparator.comparingInt(Projector::getYear))
                  .forEach(System.out::println);

        System.out.println("\nПроектори, відсортовані за роком випуску (спадання):");
        projectors.stream()
                  .sorted(Comparator.comparingInt(Projector::getYear).reversed())
                  .forEach(System.out::println);

        scanner.close();
    }
}
