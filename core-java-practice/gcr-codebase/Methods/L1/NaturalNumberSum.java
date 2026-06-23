import java.util.Scanner;

public class NaturalNumberSum {
    public static int sumNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        if (n < 1) {
            System.out.println("Please enter a natural number greater than 0.");
        } else {
            int sum = sumNaturalNumbers(n);
            System.out.printf("The sum of first %d natural numbers is %d.%n", n, sum);
        }
        scanner.close();
    }
}
