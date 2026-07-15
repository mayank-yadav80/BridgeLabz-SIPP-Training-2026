import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = null;
        try {
            System.out.print("Enter 1 to use a valid array or 2 to use a null array: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                numbers = new int[] {10, 20, 30, 40, 50};
            }
            System.out.print("Enter the index to retrieve: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid integer values");
        } finally {
            scanner.close();
        }
    }
}
