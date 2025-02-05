import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<String> products = Arrays.asList(
                "Хліб", "Молоко", "Сир", "Вода", "Яблуко",
                "Молоко", "Кефір", "Молоко", "Печиво", "Масло",
                "Капуста", "Морква"
        );

        System.out.println("Всі продукти:");
        products.stream().forEach(System.out::println);

        System.out.println("\nПродукти з назвою менше 5 символів:");
        products.stream().filter(s -> s.length() < 5).forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведіть назву продукту для підрахунку: ");
        String productToCount = scanner.nextLine();
        long countProduct = products
                .stream()
                .filter(s -> s.equalsIgnoreCase(productToCount))
                .count();
        System.out.println("Продукт '" + productToCount + "' зустрічається " + countProduct + " раз(и).");

        System.out.print("\nВведіть букву для пошуку продуктів, що починаються на неї: ");
        String letter = scanner.nextLine();
        System.out.println("Продукти, що починаються на букву '" + letter + "':");
        products.stream()
                .filter(s -> s.toLowerCase().startsWith(letter.toLowerCase()))
                .forEach(System.out::println);

        System.out.println("\nПродукти із категорії 'Молоко':");
        products.stream()
                .filter(s -> s.equalsIgnoreCase("Молоко"))
                .forEach(System.out::println);

        scanner.close();
    }
}
