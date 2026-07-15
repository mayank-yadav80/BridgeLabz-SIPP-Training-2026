import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {
    
    // Method to generate StringIndexOutOfBoundsException
    public static void generateStringIndexOutOfBoundsException(String text) {
        System.out.println("\n--- Generating StringIndexOutOfBoundsException ---");
        try {
            System.out.println("String: " + text);
            System.out.println("Length: " + text.length());
            System.out.println("Attempting to access index " + text.length() + "...");
            char ch = text.charAt(text.length()); // This will throw exception
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught during generation:");
            System.out.println("Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
    }
    
    // Method to demonstrate StringIndexOutOfBoundsException handling
    public static void demonstrateStringIndexOutOfBoundsException(String text, Scanner scanner) {
        System.out.println("\n--- Demonstrating StringIndexOutOfBoundsException Handling ---");
        System.out.println("String: " + text);
        System.out.println("Valid indices: 0 to " + (text.length() - 1));
        
        try {
            System.out.print("Enter an index to access: ");
            int index = scanner.nextInt();
            
            char ch = text.charAt(index);
            System.out.println("Character at index " + index + ": " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught!");
            System.out.println("Invalid index access");
            System.out.println("Exception Type: " + e.getClass().getSimpleName());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== StringIndexOutOfBoundsException Demo ===");
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // First call the method to generate the exception
        generateStringIndexOutOfBoundsException(text);
        
        // Then demonstrate exception handling
        demonstrateStringIndexOutOfBoundsException(text, scanner);
        
        System.out.println("\n--- Program continues after handling exception ---");
        System.out.println("Program executed successfully!");
        
        scanner.close();
    }
}
