import java.util.Scanner;

public class LargestAndSecondLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        
        long tempNumber = number;
        while (tempNumber != 0 && index < maxDigit) {
            int digit = (int)(tempNumber % 10);
            digits[index] = digit;
            tempNumber = tempNumber / 10;
            index++;
        }
        
        int largest = 0;
        int secondLargest = 0;
        
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        System.out.println("\n--- Result ---");
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        
        scanner.close();
    }
}
