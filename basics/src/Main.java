import java.util.Scanner;
import java.util.Random;

public class Main {
    // Завдання 1
    public static int createNumber(int a, int b, int c) {
        return Integer.parseInt("" + a + b + c);
    }

    // Завдання 2
    public static double calculatePercentage(double value, double percent) {
        return value * percent / 100;
    }

    // Завдання 3
    public static int swapDigits(int number) {
        if (number < 100000 || number > 999999) return -1;

        int first = number / 100000;
        int second = (number / 10000) % 10;
        int fifth = (number / 10) % 10;
        int sixth = number % 10;

        return sixth * 100000 +
                fifth * 10000 +
                (number / 1000 % 10) * 1000 +
                (number / 100 % 10) * 100 +
                second * 10 +
                first;
    }

    // Завдання 4
    public static String determineSeason(int month) {
        return switch (month) {
            case 1, 2, 12 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Autumn";
            default -> "Error: Number out of range";
        };
    }

    // Завдання 5
    public static int[] modifyArray(int[] arr) {
        if (arr.length < 2) return arr;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) minIndex = i;
            if (arr[i] > arr[maxIndex]) maxIndex = i;
        }

        int start = minIndex < maxIndex ? minIndex : maxIndex;
        int end = minIndex > maxIndex ? minIndex : maxIndex;

        for (int i = start + 1; i < end; i++) arr[i] *= 2;

        return arr;
    }

    // Завдання 6
    public static void printOddNumbersInRange(int start, int end) {
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        for (int i = start; i <= end; i++) if (i % 2 != 0) System.out.print(i + " ");
        System.out.println();
    }

    // Завдання 7
    public static void countArrayElements(int[] arr) {
        int positive = 0, negative = 0, zero = 0;
        for (int num : arr) {
            if (num > 0) positive++;
            else if (num < 0) negative++;
            else zero++;
        }
        System.out.println("Positive: " + positive + ", Negative: " + negative + ", Zero: " + zero);
    }

    // Завдання 8
    public static void calculateOrderCost() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int people = scanner.nextInt();
        double totalCost = 0;

        for (int i = 0; i < people; i++) {
            System.out.println("Person " + (i + 1) + " menu:");
            double personTotal = 0;
            boolean ordering = true;
            while (ordering) {
                System.out.println("1. Coffee - $2.50\n2. Cake - $5.00\n3. Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> personTotal += 2.5;
                    case 2 -> personTotal += 5.0;
                    case 3 -> ordering = false;
                    default -> System.out.println("Invalid option");
                }
            }
            totalCost += personTotal;
        }
        System.out.println("Total cost: $" + totalCost);
    }

    // Завдання 9
    public static int[][] generateRandomArray(Scanner scanner) {
        System.out.print("Введіть кількість рядків: ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість елементів у кожному рядку: ");
        int columns = scanner.nextInt();
        System.out.print("Введіть мінімальне значення діапазону: ");
        int min = scanner.nextInt();
        System.out.print("Введіть максимальне значення діапазону: ");
        int max = scanner.nextInt();

        int[][] array = new int[rows][columns];
        Random random = new Random();

        for (int i = 0; i < rows; i++) for (int j = 0; j < columns; j++) array[i][j] = random.nextInt(max - min + 1) + min;

        return array;
    }

    public static int[][] inputArrayManually(Scanner scanner) {
        System.out.print("Введіть кількість рядків: ");
        int rows = scanner.nextInt();
        scanner.nextLine();

        int[][] array = new int[rows][];

        for (int i = 0; i < rows; i++) {
            System.out.print("Введіть елементи для рядка " + (i + 1) + " через кому: ");
            String line = scanner.nextLine();
            String[] numbers = line.split(",");

            array[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) array[i][j] = Integer.parseInt(numbers[j].trim());
        }

        return array;
    }

    public static double[] calculateZeroToNonZeroRatios(int[][] array) {
        double[] ratioArray = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            int zeroCount = 0;
            int nonZeroCount = 0;

            for (int num : array[i]) {
                if (num == 0) zeroCount++;
                else nonZeroCount++;
            }

            if (nonZeroCount > 0) ratioArray[i] = (double) zeroCount / nonZeroCount;
            else ratioArray[i] = zeroCount > 0 ? Double.POSITIVE_INFINITY : 0;
        }

        return ratioArray;
    }

    // Завдання 10
    public static int[][] create2DArrayFrom1D(int[] arr) {
        int evenCount = 0, oddCount = 0, negativeCount = 0, positiveCount = 0;

        for (int num : arr) {
            if (num % 2 == 0) evenCount++;
            if (num % 2 != 0) oddCount++;
            if (num < 0) negativeCount++;
            if (num > 0) positiveCount++;
        }

        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];
        int[] negative = new int[negativeCount];
        int[] positive = new int[positiveCount];

        evenCount = oddCount = negativeCount = positiveCount = 0;

        for (int num : arr) {
            if (num % 2 == 0) even[evenCount++] = num;
            if (num % 2 != 0) odd[oddCount++] = num;
            if (num < 0) negative[negativeCount++] = num;
            if (num > 0) positive[positiveCount++] = num;
        }

        return new int[][]{even, odd, negative, positive};
    }

    // Завдання 11
    public static int sumInRange(int start, int end) {
        int lowerBound = start < end ? start : end;
        int upperBound = start > end ? start : end;

        int sum = 0;
        for (int i = lowerBound; i <= upperBound; i++) {
            sum += i;
        }

        return sum;
    }

    // Завдання 12
    public static double[] reorderRelativeToMax(double[] array) {
        double max = array[0];
        for (double num : array) {
            if (num > max) max = num;
        }

        int n = array.length;
        double[] result = new double[n];
        int left = 0, right = n - 1;

        for (double num : array) {
            if (num < max) result[left++] = num;
            else result[right--] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        // 1
        int a = 7, b = 3, c = 8;
        System.out.println("Task 1: " + createNumber(a, b, c));

        // 2
        double value = 50, percent = 10;
        System.out.println("Task 2: " + calculatePercentage(value, percent));

        // 3
        int sixDigitNumber = 723895;
        System.out.println("Task 3: " + swapDigits(sixDigitNumber));

        // 4
        int month = 5;
        System.out.println("Task 4: " + determineSeason(month));

        // 5
        int[] arr = {1, 0, 3, 5, 7, 2};
        int[] modifiedArray = modifyArray(arr);
        System.out.print("Task 5: ");
        for (int num : modifiedArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 6
        System.out.print("Task 6: ");
        printOddNumbersInRange(20, 11);

        // 7
        int[] arrayWithNegatives = {-3, 5, 0, -1, 2, 0, 8};
        System.out.print("Task 7: ");
        countArrayElements(arrayWithNegatives);

        // 8
        System.out.println("Task 8: ");
        calculateOrderCost();

        // 9
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a method of creating an array:");
        System.out.println("1 - Random numbers in the specified range");
        System.out.println("2 - Enter numbers manually separated by commas");
        int choice = scanner.nextInt();
        scanner.nextLine();

        int[][] array2D;

        if (choice == 1) {
            array2D = generateRandomArray(scanner);
        } else if (choice == 2) {
            array2D = inputArrayManually(scanner);
        } else {
            return;
        }

        double[] ratioArray = calculateZeroToNonZeroRatios(array2D);

        System.out.println("Array:");
        for (int[] row : array2D) {
            for (int num : row) System.out.print(num + " ");
            System.out.println();
        }

        System.out.println("Array of ratios of the number of zeros to non-zero elements:");
        for (double ratio : ratioArray) System.out.printf("%.2f ", ratio);

        // 10
        int[] oneDimArray = {-3, 4, 0, 5, -2, 6, 0, -1};
        int[][] dividedArray = create2DArrayFrom1D(oneDimArray);
        System.out.println("Task 10: ");
        System.out.println("Even numbers: ");
        for (int num : dividedArray[0]) System.out.print(num + " ");
        System.out.println("\nOdd numbers: ");
        for (int num : dividedArray[1]) System.out.print(num + " ");
        System.out.println("\nNegative numbers: ");
        for (int num : dividedArray[2]) System.out.print(num + " ");
        System.out.println("\nPositive numbers: ");
        for (int num : dividedArray[3]) System.out.print(num + " ");
        System.out.println();

        // 11
        int start = 3, end = 7;
        System.out.println("Task 11: " + sumInRange(start, end));

        // 12
        double[] array = {1.2, 0.5, 7.0, 2.6, 5.0};
        double[] orderedArray = reorderRelativeToMax(array);
        System.out.print("Task 12: ");
        for (double num : orderedArray) System.out.print(num + " ");
        System.out.println();
    }
}