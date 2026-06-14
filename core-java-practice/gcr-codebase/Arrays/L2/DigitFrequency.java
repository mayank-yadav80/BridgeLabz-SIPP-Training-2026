import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        // Find the count of digits
        long tempNumber = Math.abs(number);
        int digitCount = 0;
        while (tempNumber != 0) {
            digitCount++;
            tempNumber = tempNumber / 10;
        }
        
        // Store digits in array
        int[] digits = new int[digitCount];
        tempNumber = Math.abs(number);
        int index = 0;
        while (tempNumber != 0) {
            int digit = (int)(tempNumber % 10);
            digits[index] = digit;
            tempNumber = tempNumber / 10;
            index++;
        }
        
        // Calculate frequency of each digit
        int[] frequency = new int[10];
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        
        // Display frequency
        System.out.println("\n--- Digit Frequency ---");
        System.out.println("Number: " + number);
        System.out.println("\nFrequency of each digit:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " appears " + frequency[i] + " time(s)");
            }
        }
        
        scanner.close();
    }
}
