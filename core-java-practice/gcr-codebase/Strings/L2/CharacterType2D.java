import java.util.Scanner;

public class CharacterType2D {
    
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
    
    // Method to check if character is vowel or consonant
    public static String getCharacterType(char ch) {
        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }
        
        if ((ch >= 'a' && ch <= 'z')) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        
        return "Not a Letter";
    }
    
    // Method to find vowels and consonants with characters
    public static String[][] getCharacterTypes(String text) {
        int textLength = findStringLength(text);
        String[][] charTypes = new String[textLength][2];
        
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            charTypes[i][0] = String.valueOf(ch);
            charTypes[i][1] = getCharacterType(ch);
        }
        
        return charTypes;
    }
    
    // Method to display 2D array in tabular format
    public static void display2DArray(String[][] charTypes) {
        System.out.println("\n--- Character Analysis ---");
        System.out.println("Character\tType");
        System.out.println("---------\t----");
        
        for (int i = 0; i < charTypes.length; i++) {
            System.out.println(charTypes[i][0] + "\t\t" + charTypes[i][1]);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        // Get character types
        String[][] charTypes = getCharacterTypes(text);
        
        // Display results
        display2DArray(charTypes);
        
        scanner.close();
    }
}
