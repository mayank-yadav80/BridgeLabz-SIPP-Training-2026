import java.util.Scanner;

public class StringLengthWithoutMethod {
    
    // Method to find string length without using length() method
    public static int findStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception caught when index is out of bounds
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Find length using user-defined method
        int lengthUserDefined = findStringLength(text);
        System.out.println("\nLength using user-defined method: " + lengthUserDefined);
        
        // Find length using built-in length() method
        int lengthBuiltIn = text.length();
        System.out.println("Length using built-in length(): " + lengthBuiltIn);
        
        // Compare results
        if (lengthUserDefined == lengthBuiltIn) {
            System.out.println("\nBoth methods return the same result: " + lengthUserDefined);
        } else {
            System.out.println("\nResults differ!");
        }
        
        scanner.close();
    }
}
