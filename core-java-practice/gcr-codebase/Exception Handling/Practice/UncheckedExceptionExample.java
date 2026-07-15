import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the numerator: ");
            double numerator = scanner.nextDouble();
            System.out.print("Enter the denominator: ");
            double denominator = scanner.nextDouble();
            double result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid numeric values");
        } finally {
            scanner.close();
        }
    }
}
