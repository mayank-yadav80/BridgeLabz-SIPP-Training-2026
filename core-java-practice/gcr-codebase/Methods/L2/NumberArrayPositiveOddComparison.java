import java.util.Scanner;

public class NumberArrayPositiveOddComparison {
    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        }
        if (number1 < number2) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Enter number %d: ", i + 1);
            numbers[i] = scanner.nextInt();
        }

        for (int number : numbers) {
            if (number < 0) {
                System.out.printf("%d is negative.%n", number);
            } else if (isPositive(number)) {
                System.out.printf("%d is positive and %s.%n", number, isEven(number) ? "even" : "odd");
            } else {
                System.out.printf("%d is zero.%n", number);
            }
        }

        int comparisonResult = compare(numbers[0], numbers[numbers.length - 1]);
        if (comparisonResult > 0) {
            System.out.println("The first element is greater than the last element.");
        } else if (comparisonResult < 0) {
            System.out.println("The first element is less than the last element.");
        } else {
            System.out.println("The first and last elements are equal.");
        }

        scanner.close();
    }
}
