import java.util.Scanner;

public class StringComparison {
    
    // Method to compare two strings using charAt()
    public static boolean compareStringsUsingCharAt(String str1, String str2) {
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
        
        System.out.print("Enter first string: ");
        String string1 = scanner.next();
        
        System.out.print("Enter second string: ");
        String string2 = scanner.next();
        
        // Compare using charAt() method
        boolean resultCharAt = compareStringsUsingCharAt(string1, string2);
        System.out.println("\nComparison using charAt(): " + resultCharAt);
        
        // Compare using built-in equals() method
        boolean resultEquals = string1.equals(string2);
        System.out.println("Comparison using equals(): " + resultEquals);
        
        // Check if results are the same
        if (resultCharAt == resultEquals) {
            System.out.println("\nResults are the same: Both methods give " + resultCharAt);
        } else {
            System.out.println("\nResults are different!");
        }
        
        scanner.close();
    }
}
