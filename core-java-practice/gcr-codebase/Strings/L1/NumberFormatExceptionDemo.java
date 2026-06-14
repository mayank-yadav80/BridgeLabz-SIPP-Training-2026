import java.util.Scanner;

public class NumberFormatExceptionDemo {
    
    // Method to generate NumberFormatException
    public static void generateNumberFormatException(String text) {
        System.out.println("\n--- Generating NumberFormatException ---");
        try {
            System.out.println("Input text: " + text);
            System.out.println("Attempting to parse as integer...");
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught during generation:");
            System.out.println("Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
    }
    
    // Method to demonstrate NumberFormatException handling
    public static void demonstrateNumberFormatException(String text) {
        System.out.println("\n--- Demonstrating NumberFormatException Handling ---");
        
        try {
            System.out.println("Input text: " + text);
            System.out.println("Attempting to extract number using Integer.parseInt()...");
            int number = Integer.parseInt(text);
            System.out.println("Successfully parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught!");
            System.out.println("Input contains non-numeric characters");
            System.out.println("Exception Type: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught!");
            System.out.println("Error: " + e.getMessage());
            System.out.println("Exception Type: " + e.getClass().getSimpleName());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== NumberFormatException Demo ===");
        
        System.out.print("Enter a string (numeric or non-numeric): ");
        String text = scanner.nextLine();
        
        // First call the method to generate the exception
        generateNumberFormatException(text);
        
        // Then demonstrate exception handling
        demonstrateNumberFormatException(text);
        
        System.out.println("\n--- Program continues after handling exception ---");
        System.out.println("Program executed successfully!");
        
        scanner.close();
    }
}
