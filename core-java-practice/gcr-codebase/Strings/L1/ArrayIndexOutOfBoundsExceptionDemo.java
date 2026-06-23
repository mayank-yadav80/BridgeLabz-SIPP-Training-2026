import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {
    
    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        System.out.println("\n--- Generating ArrayIndexOutOfBoundsException ---");
        try {
            System.out.println("Array length: " + names.length);
            System.out.println("Attempting to access index " + names.length + "...");
            String name = names[names.length]; // This will throw exception
            System.out.println("Name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught during generation:");
            System.out.println("Exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
    }
    
    // Method to demonstrate ArrayIndexOutOfBoundsException handling
    public static void demonstrateArrayIndexOutOfBoundsException(String[] names, Scanner scanner) {
        System.out.println("\n--- Demonstrating ArrayIndexOutOfBoundsException Handling ---");
        
        System.out.println("Array of names:");
        for (int i = 0; i < names.length; i++) {
            System.out.println("Index " + i + ": " + names[i]);
        }
        System.out.println("Valid indices: 0 to " + (names.length - 1));
        
        try {
            System.out.print("Enter an index to access: ");
            int index = scanner.nextInt();
            String name = names[index];
            System.out.println("Name at index " + index + ": " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught!");
            System.out.println("Index is outside the bounds of the array");
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
        
        System.out.println("=== ArrayIndexOutOfBoundsException Demo ===");
        
        System.out.print("Enter number of names: ");
        int numberOfNames = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        String[] names = new String[numberOfNames];
        
        System.out.println("Enter names:");
        for (int i = 0; i < numberOfNames; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        
        // First call the method to generate the exception
        generateArrayIndexOutOfBoundsException(names);
        
        // Then demonstrate exception handling
        demonstrateArrayIndexOutOfBoundsException(names, scanner);
        
        System.out.println("\n--- Program continues after handling exception ---");
        System.out.println("Program executed successfully!");
        
        scanner.close();
    }
}
