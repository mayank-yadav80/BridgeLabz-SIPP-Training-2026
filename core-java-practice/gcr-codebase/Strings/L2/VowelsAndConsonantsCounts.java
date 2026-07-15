import java.util.Scanner;

public class VowelsAndConsonantsCounts {
    
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
    
    // Method to find vowels and consonants count
    public static int[] countVowelsAndConsonants(String text) {
        int[] counts = new int[2]; // [vowelCount, consonantCount]
        counts[0] = 0;
        counts[1] = 0;
        
        int textLength = findStringLength(text);
        
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            String type = getCharacterType(ch);
            
            if (type.equals("Vowel")) {
                counts[0]++;
            } else if (type.equals("Consonant")) {
                counts[1]++;
            }
        }
        
        return counts;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        // Count vowels and consonants
        int[] counts = countVowelsAndConsonants(text);
        
        System.out.println("\n--- Results ---");
        System.out.println("Total Vowels: " + counts[0]);
        System.out.println("Total Consonants: " + counts[1]);
        
        scanner.close();
    }
}
