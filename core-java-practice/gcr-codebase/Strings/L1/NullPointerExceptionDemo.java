import java.util.Scanner;

public class NullPointerExceptionDemo {
    
    // Method to generate NullPointerException
    @SuppressWarnings("null")
    public static void generateNullPointerException() {
        System.out.println("\n--- Generating NullPointerException ---");
        String text = null;
        try {
            System.out.println("Calling length() on null string...");
            int length = text.length(); // This will throw NullPointerException
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("Exception caught during generation (but we continue):");
            System.out.println("Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
    }
    
    // Method to demonstrate NullPointerException handling
    @SuppressWarnings("null")
    public static void demonstrateNullPointerException() {
        System.out.println("\n--- Demonstrating NullPointerException Handling ---");
        String text = null;
        try {
            System.out.println("Attempting to call toUpperCase() on null string...");
            String result = text.toUpperCase(); // This will throw NullPointerException
            System.out.println("Result: " + result);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught!");
            System.out.println("Cannot call methods on a null reference");
            System.out.println("Exception Type: " + e.getClass().getSimpleName());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== NullPointerException Demo ===");
        
        // First call the method to generate the exception
        generateNullPointerException();
        
        // Then refactor the code to handle the exception
        demonstrateNullPointerException();
        
        System.out.println("\n--- Program continues after handling exception ---");
        System.out.println("Program executed successfully!");
        
        scanner.close();
    }
}
