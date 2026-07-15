import java.util.Scanner;

public class SplitTextIntoWords {
    
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
    
    // Method to split text into words using charAt()
    public static String[] splitTextIntoWords(String text) {
        int textLength = findStringLength(text);
        
        // Count spaces to determine number of words
        int spaceCount = 0;
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        
        int wordCount = spaceCount + 1;
        
        // Create array to store space indexes
        int[] spaceIndexes = new int[spaceCount];
        int spaceIndex = 0;
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceIndex] = i;
                spaceIndex++;
            }
        }
        
        // Extract words
        String[] words = new String[wordCount];
        int startIndex = 0;
        
        for (int i = 0; i < wordCount; i++) {
            int endIndex;
            if (i < spaceCount) {
                endIndex = spaceIndexes[i];
            } else {
                endIndex = textLength;
            }
            
            String word = "";
            for (int j = startIndex; j < endIndex; j++) {
                word = word + text.charAt(j);
            }
            words[i] = word;
            startIndex = endIndex + 1;
        }
        
        return words;
    }
    
    // Method to compare two string arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        // Split using user-defined method
        String[] wordsUserDefined = splitTextIntoWords(text);
        System.out.println("\nWords using user-defined method:");
        for (int i = 0; i < wordsUserDefined.length; i++) {
            System.out.println((i + 1) + ". " + wordsUserDefined[i]);
        }
        
        // Split using built-in split() method
        String[] wordsBuiltIn = text.split(" ");
        System.out.println("\nWords using built-in split():");
        for (int i = 0; i < wordsBuiltIn.length; i++) {
            System.out.println((i + 1) + ". " + wordsBuiltIn[i]);
        }
        
        // Compare arrays
        boolean areEqual = compareStringArrays(wordsUserDefined, wordsBuiltIn);
        System.out.println("\n--- Comparison ---");
        System.out.println("Are both arrays equal? " + areEqual);
        
        if (areEqual) {
            System.out.println("Both methods produced the same result!");
        } else {
            System.out.println("Results differ!");
        }
        
        scanner.close();
    }
}
