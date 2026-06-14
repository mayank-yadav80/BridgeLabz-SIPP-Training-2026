import java.util.Scanner;

public class BMI2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numberOfPersons = scanner.nextInt();
        
        double[][] personData = new double[numberOfPersons][3]; // 0: height, 1: weight, 2: BMI
        String[] weightStatus = new String[numberOfPersons];
        
        // Take input for weight and height
        for (int i = 0; i < numberOfPersons; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.println("\nPerson " + (i + 1) + ":");
                System.out.print("  Weight (in kg): ");
                double weight = scanner.nextDouble();
                System.out.print("  Height (in meters): ");
                double height = scanner.nextDouble();
                
                if (weight <= 0 || height <= 0) {
                    System.out.println("Error! Please enter positive values.");
                } else {
                    personData[i][0] = height;
                    personData[i][1] = weight;
                    validInput = true;
                }
            }
        }
        
        // Calculate BMI and weight status
        for (int i = 0; i < numberOfPersons; i++) {
            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);
            
            double bmi = personData[i][2];
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                weightStatus[i] = "Normal Weight";
            } else if (bmi >= 25 && bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        // Display results
        System.out.println("\n--- BMI Details ---");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.println("  Height: " + personData[i][0] + " m");
            System.out.println("  Weight: " + personData[i][1] + " kg");
            System.out.println("  BMI: " + String.format("%.2f", personData[i][2]));
            System.out.println("  Status: " + weightStatus[i]);
        }
        
        scanner.close();
    }
}
