import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    
    // Method to generate IllegalArgumentException
    public static void generateIllegalArgumentException(String text) {
        System.out.println("\n--- Generating IllegalArgumentException ---");
        try {
            System.out.println("String: " + text);
            System.out.println("Attempting substring(5, 2) where start > end...");
            String result = text.substring(5, 2); // This will throw exception
            System.out.println("Result: " + result);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught during generation:");
            System.out.println("Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
    }
    
    // Method to demonstrate IllegalArgumentException handling
    public static void demonstrateIllegalArgumentException(String text, Scanner scanner) {
        System.out.println("\n--- Demonstrating IllegalArgumentException Handling ---");
        
        System.out.println("String: " + text);
        System.out.println("String length: " + text.length());
        
        try {
            System.out.print("Enter start index: ");
            int startIndex = scanner.nextInt();
            System.out.print("Enter end index: ");
            int endIndex = scanner.nextInt();
            
            if (startIndex > endIndex) {
                throw new IllegalArgumentException("Start index cannot be greater than end index");
            }
            
            String result = text.substring(startIndex, endIndex);
            System.out.println("Substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught!");
            System.out.println("Error: " + e.getMessage());
            System.out.println("Exception Type: " + e.getClass().getSimpleName());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught!");
            System.out.println("Index is out of bounds");
            System.out.println("Exception Type: " + e.getClass().getSimpleName());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught!");
            System.out.println("Error: " + e.getMessage());
            System.out.println("Exception Type: " + e.getClass().getSimpleName());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== IllegalArgumentException Demo ===");
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // First call the method to generate the exception
        generateIllegalArgumentException(text);
        
        // Then demonstrate exception handling
        demonstrateIllegalArgumentException(text, scanner);
        
        System.out.println("\n--- Program continues after handling exception ---");
        System.out.println("Program executed successfully!");
        
        scanner.close();
    }
}
