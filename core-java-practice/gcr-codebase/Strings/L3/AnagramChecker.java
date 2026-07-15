import java.util.Scanner;

public class AnagramChecker {
    
    // Method to check if two texts are anagrams
    public static boolean areAnagrams(String text1, String text2) {
        // Remove spaces and convert to lowercase
        String str1 = text1.replaceAll(" ", "").toLowerCase();
        String str2 = text2.replaceAll(" ", "").toLowerCase();
        
        // Check if lengths are equal
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Create frequency array for ASCII characters
        int[] frequency = new int[256];
        
        // Count frequency of characters in first string
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            frequency[ch]++;
        }
        
        // Subtract frequency of characters in second string
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            frequency[ch]--;
        }
        
        // Check if all frequencies are zero
        for (int i = 0; i < 256; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first text: ");
        String text1 = scanner.nextLine();
        
        System.out.print("Enter second text: ");
        String text2 = scanner.nextLine();
        
        boolean result = areAnagrams(text1, text2);
        
        System.out.println("\n--- Anagram Check Results ---");
        System.out.println("Text 1: " + text1);
        System.out.println("Text 2: " + text2);
        
        if (result) {
            System.out.println("\n*** '" + text1 + "' and '" + text2 + "' are ANAGRAMS ***");
        } else {
            System.out.println("\n*** '" + text1 + "' and '" + text2 + "' are NOT ANAGRAMS ***");
        }
        
        scanner.close();
    }
}
