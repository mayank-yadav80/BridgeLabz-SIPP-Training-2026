import java.util.Scanner;

public class CharacterFrequencyUsingUnique {
    
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
    
    // Method to find unique characters
    public static char[] findUniqueCharacters(String text) {
        int textLength = findStringLength(text);
        char[] tempUnique = new char[textLength];
        int uniqueCount = 0;
        
        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            
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
        
        char[] uniqueCharacters = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueCharacters[i] = tempUnique[i];
        }
        
        return uniqueCharacters;
    }
    
    // Method to find character frequency using unique characters
    public static String[][] findCharacterFrequencyWithUnique(String text) {
        int textLength = findStringLength(text);
        
        // Create frequency array
        int[] frequency = new int[256];
        
        // Count frequency
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        // Get unique characters
        char[] uniqueChars = findUniqueCharacters(text);
        
        // Create 2D array with unique characters and their frequencies
        String[][] charFreq = new String[uniqueChars.length][2];
        
        for (int i = 0; i < uniqueChars.length; i++) {
            charFreq[i][0] = String.valueOf(uniqueChars[i]);
            charFreq[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }
        
        return charFreq;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Find character frequencies using unique characters
        String[][] charFreq = findCharacterFrequencyWithUnique(text);
        
        System.out.println("\n--- Character Frequency (Using Unique Characters) ---");
        System.out.println("Character\tFrequency");
        System.out.println("---------\t---------");
        
        for (int i = 0; i < charFreq.length; i++) {
            System.out.println(charFreq[i][0] + "\t\t" + charFreq[i][1]);
        }
        
        scanner.close();
    }
}
