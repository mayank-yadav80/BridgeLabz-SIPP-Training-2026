import java.util.Scanner;

public class BMICalculator {
    public static void populateBMI(double[][] people) {
        for (int i = 0; i < people.length; i++) {
            double weight = people[i][0];
            double heightCm = people[i][1];
            double heightMeters = heightCm / 100.0;
            people[i][2] = weight / (heightMeters * heightMeters);
        }
    }

    public static String[] determineBMIStatus(double[][] people) {
        String[] statuses = new String[people.length];
        for (int i = 0; i < people.length; i++) {
            double bmi = people[i][2];
            if (bmi < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmi < 25) {
                statuses[i] = "Normal weight";
            } else if (bmi < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        return statuses;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] people = new double[10][3];

        for (int i = 0; i < people.length; i++) {
            System.out.printf("Enter weight in kg for person %d: ", i + 1);
            people[i][0] = scanner.nextDouble();
            System.out.printf("Enter height in cm for person %d: ", i + 1);
            people[i][1] = scanner.nextDouble();
        }

        populateBMI(people);
        String[] statuses = determineBMIStatus(people);

        System.out.println("Person | Weight(kg) | Height(cm) | BMI | Status");
        for (int i = 0; i < people.length; i++) {
            System.out.printf("%6d | %10.2f | %10.2f | %4.2f | %s%n",
                    i + 1, people[i][0], people[i][1], people[i][2], statuses[i]);
        }

        scanner.close();
    }
}
