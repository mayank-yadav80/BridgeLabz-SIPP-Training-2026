import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        // Find the count of digits
        long tempNumber = number;
        int digitCount = 0;
        while (tempNumber != 0) {
            digitCount++;
            tempNumber = tempNumber / 10;
        }
        
        // Store digits in array
        int[] digits = new int[digitCount];
        tempNumber = number;
        int index = 0;
        while (tempNumber != 0) {
            int digit = (int)(tempNumber % 10);
            digits[index] = digit;
            tempNumber = tempNumber / 10;
            index++;
        }
        
        // Create reverse array
        int[] reverseDigits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reverseDigits[i] = digits[digitCount - 1 - i];
        }
        
        System.out.println("\n--- Original Number ---");
        System.out.print("Digits: ");
        for (int i = digitCount - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        System.out.println();
        
        System.out.println("\n--- Reversed Number ---");
        System.out.print("Digits: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reverseDigits[i]);
        }
        System.out.println();
        
        long reversedNumber = 0;
        for (int i = 0; i < digitCount; i++) {
            reversedNumber = reversedNumber * 10 + reverseDigits[i];
        }
        
        System.out.println("\nReversed Number: " + reversedNumber);
        
        scanner.close();
    }
}
