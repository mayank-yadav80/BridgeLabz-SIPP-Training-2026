import java.util.Scanner;

public class ShortestAndLongestWords {
    
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
        
        // Count spaces
        int spaceCount = 0;
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        
        int wordCount = spaceCount + 1;
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
    
    // Method to create 2D array with words and their lengths
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] wordsWithLengths = new String[words.length][2];
        
        for (int i = 0; i < words.length; i++) {
            wordsWithLengths[i][0] = words[i];
            int length = findStringLength(words[i]);
            wordsWithLengths[i][1] = String.valueOf(length);
        }
        
        return wordsWithLengths;
    }
    
    // Method to find shortest and longest words
    public static int[] findShortestAndLongest(String[][] wordsWithLengths) {
        int[] result = new int[2]; // [shortestIndex, longestIndex]
        result[0] = 0;
        result[1] = 0;
        
        int minLength = Integer.parseInt(wordsWithLengths[0][1]);
        int maxLength = Integer.parseInt(wordsWithLengths[0][1]);
        
        for (int i = 1; i < wordsWithLengths.length; i++) {
            int length = Integer.parseInt(wordsWithLengths[i][1]);
            
            if (length < minLength) {
                minLength = length;
                result[0] = i;
            }
            
            if (length > maxLength) {
                maxLength = length;
                result[1] = i;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        // Split into words
        String[] words = splitTextIntoWords(text);
        
        // Get words with their lengths
        String[][] wordsWithLengths = getWordsWithLengths(words);
        
        // Find shortest and longest
        int[] indexes = findShortestAndLongest(wordsWithLengths);
        
        System.out.println("\n--- All Words and Their Lengths ---");
        System.out.println("Word\t\tLength");
        System.out.println("----\t\t------");
        
        for (int i = 0; i < wordsWithLengths.length; i++) {
            int length = Integer.parseInt(wordsWithLengths[i][1]);
            System.out.println(wordsWithLengths[i][0] + "\t\t" + length);
        }
        
        System.out.println("\n--- Results ---");
        int shortestIndex = indexes[0];
        int longestIndex = indexes[1];
        
        System.out.println("Shortest word: " + wordsWithLengths[shortestIndex][0] + 
                          " (Length: " + wordsWithLengths[shortestIndex][1] + ")");
        System.out.println("Longest word: " + wordsWithLengths[longestIndex][0] + 
                          " (Length: " + wordsWithLengths[longestIndex][1] + ")");
        
        scanner.close();
    }
}
