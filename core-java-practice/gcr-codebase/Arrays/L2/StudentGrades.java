import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        double[][] marks = new double[numberOfStudents][3]; // 0: Physics, 1: Chemistry, 2: Maths
        double[] percentages = new double[numberOfStudents];
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
                    marks[i][0] = physics;
                    marks[i][1] = chemistry;
                    marks[i][2] = maths;
                    validInput = true;
                }
            }
        }
        
        // Calculate percentage and grade
        for (int i = 0; i < numberOfStudents; i++) {
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = totalMarks / 3;
            
            if (percentages[i] >= 90) {
                grades[i] = 'A';
            } else if (percentages[i] >= 80) {
                grades[i] = 'B';
            } else if (percentages[i] >= 70) {
                grades[i] = 'C';
            } else if (percentages[i] >= 60) {
                grades[i] = 'D';
            } else if (percentages[i] >= 50) {
                grades[i] = 'E';
            } else {
                grades[i] = 'F';
            }
        }
        
        // Display results
        System.out.println("\n--- Student Grades ---");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.println("  Physics: " + marks[i][0]);
            System.out.println("  Chemistry: " + marks[i][1]);
            System.out.println("  Maths: " + marks[i][2]);
            System.out.println("  Percentage: " + String.format("%.2f", percentages[i]) + "%");
            System.out.println("  Grade: " + grades[i]);
        }
        
        scanner.close();
    }
}
