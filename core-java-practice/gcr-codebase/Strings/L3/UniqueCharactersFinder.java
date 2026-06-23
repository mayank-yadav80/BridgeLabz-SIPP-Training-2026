import java.util.Scanner;

public class UniqueCharactersFinder {
    
    // Method to find string length without using length()
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
    
    // Method to find unique characters
    public static char[] findUniqueCharacters(String text) {
        int textLength = findStringLength(text);
        char[] tempUnique = new char[textLength];
        int uniqueCount = 0;
        
        // Find unique characters using nested loops
        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            
            // Check if character already exists
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            
            if (isUnique) {
                tempUnique[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }
        
        // Create new array with actual unique characters
        char[] uniqueCharacters = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueCharacters[i] = tempUnique[i];
        }
        
        return uniqueCharacters;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Find unique characters
        char[] uniqueChars = findUniqueCharacters(text);
        
        System.out.println("\n--- Unique Characters ---");
        System.out.print("Unique characters: ");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i]);
            if (i < uniqueChars.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Total unique characters: " + uniqueChars.length);
        
        scanner.close();
    }
}
