import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    
    // Method to find string length
    public static int findStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception caught
        }
        return count;
    }
    
    // Method to find first non-repeating character
    public static char findFirstNonRepeating(String text) {
        int textLength = findStringLength(text);
        
        // Create frequency array for ASCII characters
        int[] frequency = new int[256];
        
        // Count frequency of each character
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        // Find first non-repeating character
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }
        
        return '\0'; // Return null character if no non-repeating character found
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Find first non-repeating character
        char result = findFirstNonRepeating(text);
        
        System.out.println("\n--- Result ---");
        if (result == '\0') {
            System.out.println("No non-repeating character found");
        } else {
            System.out.println("First non-repeating character: '" + result + "'");
        }
        
        scanner.close();
    }
}
