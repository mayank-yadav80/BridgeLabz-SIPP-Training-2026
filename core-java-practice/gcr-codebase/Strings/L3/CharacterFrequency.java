import java.util.Scanner;

public class CharacterFrequency {
    
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
    
    // Method to find character frequency
    public static String[][] findCharacterFrequency(String text) {
        int textLength = findStringLength(text);
        
        // Create frequency array for ASCII characters
        int[] frequency = new int[256];
        
        // Count frequency of each character
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        // Count how many characters have frequency > 0
        int charCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                charCount++;
            }
        }
        
        // Create 2D array to store characters and their frequencies
        String[][] charFreq = new String[charCount][2];
        int index = 0;
        
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            if (frequency[ch] > 0) {
                charFreq[index][0] = String.valueOf(ch);
                charFreq[index][1] = String.valueOf(frequency[ch]);
                frequency[ch] = 0; // Mark as processed
                index++;
            }
        }
        
        return charFreq;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Find character frequencies
        String[][] charFreq = findCharacterFrequency(text);
        
        System.out.println("\n--- Character Frequency ---");
        System.out.println("Character\tFrequency");
        System.out.println("---------\t---------");
        
        for (int i = 0; i < charFreq.length; i++) {
            System.out.println(charFreq[i][0] + "\t\t" + charFreq[i][1]);
        }
        
        scanner.close();
    }
}
