import java.util.Scanner;

public class SubstringComparison {
    
    // Method to create substring using charAt()
    public static String createSubstringUsingCharAt(String text, int startIndex, int endIndex) {
        String substring = "";
        for (int i = startIndex; i < endIndex; i++) {
            substring = substring + text.charAt(i);
        }
        return substring;
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
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        System.out.print("Enter start index: ");
        int startIndex = scanner.nextInt();
        
        System.out.print("Enter end index: ");
        int endIndex = scanner.nextInt();
        
        // Create substring using charAt()
        String substringCharAt = createSubstringUsingCharAt(text, startIndex, endIndex);
        System.out.println("\nSubstring using charAt(): " + substringCharAt);
        
        // Create substring using built-in substring()
        String substringBuiltIn = text.substring(startIndex, endIndex);
        System.out.println("Substring using substring(): " + substringBuiltIn);
        
        // Compare the two substrings
        boolean areEqual = compareStrings(substringCharAt, substringBuiltIn);
        System.out.println("\nAre the substrings equal? " + areEqual);
        
        if (areEqual) {
            System.out.println("Both methods produced the same result: " + substringCharAt);
        } else {
            System.out.println("Methods produced different results!");
        }
        
        scanner.close();
    }
}
