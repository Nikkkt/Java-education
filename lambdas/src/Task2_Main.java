import java.util.function.Function;

public class Task2_Main {
    public static void main(String[] args) {
        Function<int[], Integer> maxOfFour = nums -> Math.max(Math.max(nums[0], nums[1]), Math.max(nums[2], nums[3])); // 1
        Function<int[], Integer> minOfFour = nums -> Math.min(Math.min(nums[0], nums[1]), Math.min(nums[2], nums[3])); // 2

        int[] numbers = {5, 12, 3, 8};
        System.out.println(maxOfFour.apply(numbers));
        System.out.println(minOfFour.apply(numbers));
    }
}
