import java.util.Scanner;

public class BMITeamAnalysis {
    
    // Method to find BMI and status
    public static String[][] calculateBMIAndStatus(double[][] heightWeight) {
        String[][] result = new String[heightWeight.length][4];
        
        for (int i = 0; i < heightWeight.length; i++) {
            double weight = heightWeight[i][0];
            double heightInCm = heightWeight[i][1];
            double heightInMeters = heightInCm / 100;
            
            double bmi = weight / (heightInMeters * heightInMeters);
            
            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                status = "Normal Weight";
            } else if (bmi >= 25 && bmi < 30) {
                status = "Overweight";
            } else {
                status = "Obese";
            }
            
            result[i][0] = String.valueOf(heightInCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        
        return result;
    }
    
    // Method to display results in tabular format
    public static void displayBMIResults(String[][] bmiData) {
        System.out.println("\n--- BMI Analysis for Team Members ---");
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("------\t---------\t---------\t---\t\t------");
        
        for (int i = 0; i < bmiData.length; i++) {
            System.out.println((i + 1) + "\t" + bmiData[i][0] + "\t\t" + bmiData[i][1] + 
                             "\t\t" + bmiData[i][2] + "\t\t" + bmiData[i][3]);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfMembers = 10;
        double[][] heightWeight = new double[numberOfMembers][2];
        
        System.out.println("Enter height (cm) and weight (kg) for " + numberOfMembers + " team members:");
        
        for (int i = 0; i < numberOfMembers; i++) {
            System.out.println("\nMember " + (i + 1) + ":");
            System.out.print("  Height (cm): ");
            heightWeight[i][1] = scanner.nextDouble();
            System.out.print("  Weight (kg): ");
            heightWeight[i][0] = scanner.nextDouble();
        }
        
        // Calculate BMI and status
        String[][] bmiData = calculateBMIAndStatus(heightWeight);
        
        // Display results
        displayBMIResults(bmiData);
        
        scanner.close();
    }
}
