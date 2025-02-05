import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Task1 {
    public static boolean isPalindromic(int n) {
        String s = String.valueOf(Math.abs(n));
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    public static void main(String[] args) {
        Random random = new Random();
        Collectors Collectors = null;

        List<Integer> numbers = random.ints(20, -1000, 1000)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Згенеровані числа: " + numbers);

        long countPositive = numbers
                .stream()
                .filter(n -> n > 0)
                .count();

        long countNegative = numbers
                .stream()
                .filter(n -> n < 0)
                .count();

        long countTwoDigit = numbers
                .stream()
                .filter(n -> {
                    int abs = Math.abs(n);
                    return abs >= 10 && abs < 100;
                }).count();

        long countPalindromic = numbers
                .stream()
                .filter(Task1::isPalindromic)
                .count();

        System.out.println("Додатніх чисел: " + countPositive);
        System.out.println("Від’ємних чисел: " + countNegative);
        System.out.println("Двозначних чисел: " + countTwoDigit);
        System.out.println("Дзеркальних (паліндромних) чисел: " + countPalindromic);
    }
}
