import java.util.InputMismatchException;
import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int[] numbers = {20, 40, 60};
            System.out.print("Enter the index: ");
            int index = scanner.nextInt();
            System.out.print("Enter the divisor: ");
            int divisor = scanner.nextInt();
            try {
                int value = numbers[index];
                int result = value / divisor;
                System.out.println("Division result: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid integers");
        } finally {
            scanner.close();
        }
    }
}
