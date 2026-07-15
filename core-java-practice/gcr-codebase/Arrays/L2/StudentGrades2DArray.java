import java.util.Scanner;

public class StudentGrades2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        double[][] marksData = new double[numberOfStudents][4]; // 0: Physics, 1: Chemistry, 2: Maths, 3: Percentage
        char[] grades = new char[numberOfStudents];
        
        // Take input for marks
        for (int i = 0; i < numberOfStudents; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.println("\nStudent " + (i + 1) + ":");
                System.out.print("  Physics marks: ");
                double physics = scanner.nextDouble();
                System.out.print("  Chemistry marks: ");
                double chemistry = scanner.nextDouble();
                System.out.print("  Maths marks: ");
                double maths = scanner.nextDouble();
                
                if (physics < 0 || chemistry < 0 || maths < 0) {
                    System.out.println("Error! Marks cannot be negative. Please try again.");
                } else {
                    marksData[i][0] = physics;
                    marksData[i][1] = chemistry;
                    marksData[i][2] = maths;
                    validInput = true;
                }
            }
        }
        
        // Calculate percentage and grade
        for (int i = 0; i < numberOfStudents; i++) {
            double totalMarks = marksData[i][0] + marksData[i][1] + marksData[i][2];
            marksData[i][3] = totalMarks / 3;
            
            if (marksData[i][3] >= 90) {
                grades[i] = 'A';
            } else if (marksData[i][3] >= 80) {
                grades[i] = 'B';
            } else if (marksData[i][3] >= 70) {
                grades[i] = 'C';
            } else if (marksData[i][3] >= 60) {
                grades[i] = 'D';
            } else if (marksData[i][3] >= 50) {
                grades[i] = 'E';
            } else {
                grades[i] = 'F';
            }
        }
        
        // Display results
        System.out.println("\n--- Student Grades (2D Array) ---");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.println("  Physics: " + marksData[i][0]);
            System.out.println("  Chemistry: " + marksData[i][1]);
            System.out.println("  Maths: " + marksData[i][2]);
            System.out.println("  Percentage: " + String.format("%.2f", marksData[i][3]) + "%");
            System.out.println("  Grade: " + grades[i]);
        }
        
        scanner.close();
    }
}
