import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numberOfPersons = scanner.nextInt();
        
        double[] weights = new double[numberOfPersons];
        double[] heights = new double[numberOfPersons];
        double[] bmis = new double[numberOfPersons];
        String[] weightStatuses = new String[numberOfPersons];
        
        // Take input for weight and height
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("  Weight (in kg): ");
            weights[i] = scanner.nextDouble();
            System.out.print("  Height (in meters): ");
            heights[i] = scanner.nextDouble();
        }
        
        // Calculate BMI and weight status
        for (int i = 0; i < numberOfPersons; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            
            if (bmis[i] < 18.5) {
                weightStatuses[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] < 25) {
                weightStatuses[i] = "Normal Weight";
            } else if (bmis[i] >= 25 && bmis[i] < 30) {
                weightStatuses[i] = "Overweight";
            } else {
                weightStatuses[i] = "Obese";
            }
        }
        
        // Display results
        System.out.println("\n--- BMI Details ---");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.println("  Height: " + heights[i] + " m");
            System.out.println("  Weight: " + weights[i] + " kg");
            System.out.println("  BMI: " + String.format("%.2f", bmis[i]));
            System.out.println("  Status: " + weightStatuses[i]);
        }
        
        scanner.close();
    }
}
