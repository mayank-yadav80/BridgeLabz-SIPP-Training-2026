import java.util.Scanner;

public class CharArrayComparison {
    
    // Method to return characters in a string without using toCharArray()
    public static char[] getCharArray(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }
    
    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Get char array using user-defined method
        char[] charArrayUserDefined = getCharArray(text);
        System.out.println("\nChar array using user-defined method:");
        for (char c : charArrayUserDefined) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        // Get char array using built-in toCharArray()
        char[] charArrayBuiltIn = text.toCharArray();
        System.out.println("Char array using built-in toCharArray():");
        for (char c : charArrayBuiltIn) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        // Compare the two arrays
        boolean areEqual = compareCharArrays(charArrayUserDefined, charArrayBuiltIn);
        System.out.println("\nAre the char arrays equal? " + areEqual);
        
        if (areEqual) {
            System.out.println("Both methods produced the same result!");
        } else {
            System.out.println("Methods produced different results!");
        }
        
        scanner.close();
    }
}
