import java.util.Scanner;

public class TrimSpaces {
    
    // Method to find string length without using length() method
    public static int findStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception caught when index is out of bounds
        }
        return count;
    }
    
    // Method to trim leading and trailing spaces
    public static int[] getTrimIndexes(String text) {
        int textLength = findStringLength(text);
        int[] indexes = new int[2];
        
        // Find starting point (skip leading spaces)
        int startIndex = 0;
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) != ' ') {
                startIndex = i;
                break;
            }
        }
        
        // Find ending point (skip trailing spaces)
        int endIndex = textLength - 1;
        for (int i = textLength - 1; i >= 0; i--) {
            if (text.charAt(i) != ' ') {
                endIndex = i;
                break;
            }
        }
        
        indexes[0] = startIndex;
        indexes[1] = endIndex + 1;
        
        return indexes;
    }
    
    // Method to create substring using charAt()
    public static String createSubstring(String text, int startIndex, int endIndex) {
        String substring = "";
        for (int i = startIndex; i < endIndex; i++) {
            substring = substring + text.charAt(i);
        }
        return substring;
    }
    
    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        int len1 = findStringLength(str1);
        int len2 = findStringLength(str2);
        
        if (len1 != len2) {
            return false;
        }
        
        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text (with leading/trailing spaces): ");
        String text = scanner.nextLine();
        
        System.out.println("\nOriginal text: '" + text + "'");
        System.out.println("Original length: " + findStringLength(text));
        
        // Trim using user-defined method
        int[] indexes = getTrimIndexes(text);
        String trimmedUserDefined = createSubstring(text, indexes[0], indexes[1]);
        
        System.out.println("\nTrimmed using user-defined method: '" + trimmedUserDefined + "'");
        System.out.println("Trimmed length: " + findStringLength(trimmedUserDefined));
        
        // Trim using built-in trim() method
        String trimmedBuiltIn = text.trim();
        
        System.out.println("\nTrimmed using built-in trim(): '" + trimmedBuiltIn + "'");
        System.out.println("Trimmed length: " + findStringLength(trimmedBuiltIn));
        
        // Compare results
        boolean areEqual = compareStrings(trimmedUserDefined, trimmedBuiltIn);
        System.out.println("\n--- Comparison ---");
        System.out.println("Are both methods producing the same result? " + areEqual);
        
        if (areEqual) {
            System.out.println("Success! Both methods trimmed the text correctly.");
        } else {
            System.out.println("Results differ!");
        }
        
        scanner.close();
    }
}
