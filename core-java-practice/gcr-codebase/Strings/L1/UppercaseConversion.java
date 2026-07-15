import java.util.Scanner;

public class UppercaseConversion {
    
    // Method to convert text to uppercase using charAt()
    public static String convertToUppercaseUsingCharAt(String text) {
        String uppercase = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                // ASCII value of 'a' is 97 and 'A' is 65, difference is 32
                ch = (char)(ch - 32);
            }
            uppercase = uppercase + ch;
        }
        return uppercase;
    }
    
    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        // Convert to uppercase using user-defined method
        String uppercaseCharAt = convertToUppercaseUsingCharAt(text);
        System.out.println("\nOriginal text: " + text);
        System.out.println("Converted using charAt(): " + uppercaseCharAt);
        
        // Convert to uppercase using built-in toUpperCase()
        String uppercaseBuiltIn = text.toUpperCase();
        System.out.println("Converted using toUpperCase(): " + uppercaseBuiltIn);
        
        // Compare the two results
        boolean areEqual = compareStrings(uppercaseCharAt, uppercaseBuiltIn);
        System.out.println("\n--- Comparison ---");
        System.out.println("Are both methods producing the same result? " + areEqual);
        
        if (areEqual) {
            System.out.println("Success! Both methods converted the text to uppercase correctly.");
        } else {
            System.out.println("Results differ!");
        }
        
        scanner.close();
    }
}
