import java.util.Scanner;

public class ChocolateDistribution {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int remainder = number % divisor;
        int quotient = number / divisor;
        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of chocolates: ");
        int chocolates = scanner.nextInt();
        System.out.print("Enter the number of children: ");
        int children = scanner.nextInt();
        if (children == 0) {
            System.out.println("Number of children must be greater than 0.");
        } else {
            int[] result = findRemainderAndQuotient(chocolates, children);
            System.out.printf("Each child gets %d chocolates and %d chocolates remain.%n", result[1], result[0]);
        }
        scanner.close();
    }
}
