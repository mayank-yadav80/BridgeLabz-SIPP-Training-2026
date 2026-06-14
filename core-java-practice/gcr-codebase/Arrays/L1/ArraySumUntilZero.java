import java.util.Scanner;

public class ArraySumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        System.out.println("Enter numbers (enter 0 or negative number to stop):");
        while (true) {
            System.out.print("Number " + (index + 1) + ": ");
            double userInput = scanner.nextDouble();
            
            if (userInput <= 0) {
                break;
            }
            
            if (index >= 10) {
                break;
            }
            
            numbers[index] = userInput;
            index++;
        }
        
        System.out.println("\n--- Numbers Entered ---");
        for (int i = 0; i < index; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
            total += numbers[i];
        }
        
        System.out.println("\n--- Summary ---");
        System.out.println("Total numbers entered: " + index);
        System.out.println("Sum of all numbers: " + total);
        
        scanner.close();
    }
}
