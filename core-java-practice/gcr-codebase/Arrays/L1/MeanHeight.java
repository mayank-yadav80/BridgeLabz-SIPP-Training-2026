import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] heights = new double[11];
        double sum = 0.0;
        
        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height (in meters): ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }
        
        double meanHeight = sum / heights.length;
        
        System.out.println("\n--- Result ---");
        System.out.println("Mean height of the football team: " + meanHeight + " meters");
        
        scanner.close();
    }
}
