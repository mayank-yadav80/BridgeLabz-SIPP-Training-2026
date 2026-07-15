import java.util.Scanner;

public class PalindromeChecker {
    
    // Logic 1: Compare characters from start and end
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;
        
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    // Logic 2: Recursive approach
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    
    // Logic 3: Using character arrays
    public static String reverseStringUsingCharAt(String text) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }
        return reversed;
    }
    
    public static boolean isPalindromeCharArray(String text) {
        char[] original = text.toCharArray();
        String reversedStr = reverseStringUsingCharAt(text);
        char[] reversed = reversedStr.toCharArray();
        
        if (original.length != reversed.length) {
            return false;
        }
        
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Remove spaces and convert to lowercase for comparison
        String cleanText = text.replaceAll(" ", "").toLowerCase();
        
        System.out.println("\n--- Palindrome Check Results ---");
        System.out.println("Original text: " + text);
        System.out.println("Clean text: " + cleanText);
        
        // Logic 1: Iterative
        boolean result1 = isPalindromeIterative(cleanText);
        System.out.println("\nLogic 1 (Iterative): " + result1);
        
        // Logic 2: Recursive
        boolean result2 = isPalindromeRecursive(cleanText, 0, cleanText.length() - 1);
        System.out.println("Logic 2 (Recursive): " + result2);
        
        // Logic 3: Character Arrays
        boolean result3 = isPalindromeCharArray(cleanText);
        System.out.println("Logic 3 (Character Arrays): " + result3);
        
        if (result1 && result2 && result3) {
            System.out.println("\n*** '" + text + "' is a PALINDROME ***");
        } else {
            System.out.println("\n*** '" + text + "' is NOT a PALINDROME ***");
        }
        
        scanner.close();
    }
}
