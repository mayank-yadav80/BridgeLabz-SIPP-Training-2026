import java.util.Scanner;

public class CharacterFrequencyNestedLoop {
    
    // Method to find character frequency using nested loops
    public static String[] findCharacterFrequencyNestedLoop(String text) {
        char[] chars = text.toCharArray();
        int[] frequency = new int[chars.length];
        
        // Find frequency using nested loops
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') { // '0' marks already counted characters
                frequency[i] = 1;
                
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        frequency[i]++;
                        chars[j] = '0'; // Mark as counted
                    }
                }
            }
        }
        
        // Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }
        
        // Create result array
        String[] result = new String[uniqueCount];
        int index = 0;
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " -> " + frequency[i];
                index++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Find character frequencies using nested loops
        String[] result = findCharacterFrequencyNestedLoop(text);
        
        System.out.println("\n--- Character Frequency (Using Nested Loops) ---");
        System.out.println("Character\tFrequency");
        System.out.println("---------\t---------");
        
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        
        scanner.close();
    }
}
