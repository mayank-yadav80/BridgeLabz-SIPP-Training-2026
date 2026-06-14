import java.util.Scanner;

public class LowercaseConversion {
    
    // Method to convert text to lowercase using charAt()
    public static String convertToLowercaseUsingCharAt(String text) {
        String lowercase = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                // ASCII value of 'A' is 65 and 'a' is 97, difference is 32
                ch = (char)(ch + 32);
            }
            lowercase = lowercase + ch;
        }
        return lowercase;
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
        
        // Convert to lowercase using user-defined method
        String lowercaseCharAt = convertToLowercaseUsingCharAt(text);
        System.out.println("\nOriginal text: " + text);
        System.out.println("Converted using charAt(): " + lowercaseCharAt);
        
        // Convert to lowercase using built-in toLowerCase()
        String lowercaseBuiltIn = text.toLowerCase();
        System.out.println("Converted using toLowerCase(): " + lowercaseBuiltIn);
        
        // Compare the two results
        boolean areEqual = compareStrings(lowercaseCharAt, lowercaseBuiltIn);
        System.out.println("\n--- Comparison ---");
        System.out.println("Are both methods producing the same result? " + areEqual);
        
        if (areEqual) {
            System.out.println("Success! Both methods converted the text to lowercase correctly.");
        } else {
            System.out.println("Results differ!");
        }
        
        scanner.close();
    }
}
