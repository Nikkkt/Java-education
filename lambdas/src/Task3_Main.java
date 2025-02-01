import java.util.function.Predicate;

public class Task3_Main {
    static int sumByCondition(int[] arr, Predicate<Integer> condition) {
        int sum = 0;
        for (int num : arr) if (condition.test(num)) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        int[] array = {1, -5, 8, 10, -2, 4};

        Predicate<Integer> isEqualTo = x -> x == 10;
        Predicate<Integer> isOutOfRange = x -> x < 3 || x > 7;
        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> isNegative = x -> x < 0;

        System.out.println(sumByCondition(array, isEqualTo));    // 10
        System.out.println(sumByCondition(array, isOutOfRange)); // 4
        System.out.println(sumByCondition(array, isPositive));  // 23
        System.out.println(sumByCondition(array, isNegative));  // -7
    }
}
