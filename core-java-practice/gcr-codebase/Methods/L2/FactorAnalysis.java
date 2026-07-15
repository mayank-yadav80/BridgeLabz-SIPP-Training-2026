import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FactorAnalysis {
    public static int[] findFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        int[] result = new int[factors.size()];
        for (int i = 0; i < factors.size(); i++) {
            result[i] = factors.get(i);
        }
        return result;
    }

    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long productFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double sumOfSquareFactors(int[] factors) {
        double sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int[] factors = findFactors(number);
            System.out.print("Factors: ");
            for (int factor : factors) {
                System.out.print(factor + " ");
            }
            System.out.println();
            System.out.printf("Sum of factors: %d%n", sumFactors(factors));
            System.out.printf("Product of factors: %d%n", productFactors(factors));
            System.out.printf("Sum of squares of factors: %.0f%n", sumOfSquareFactors(factors));
        }
        scanner.close();
    }
}
