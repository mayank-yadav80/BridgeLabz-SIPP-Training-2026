import java.util.Scanner;

public class TrigonometricFunctionsCalculator {
    public static double[] calculateTrigonometricFunctions(double degrees) {
        double radians = Math.toRadians(degrees);
        return new double[]{Math.sin(radians), Math.cos(radians), Math.tan(radians)};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an angle in degrees: ");
        double degrees = scanner.nextDouble();
        double[] values = calculateTrigonometricFunctions(degrees);
        System.out.printf("Sine(%.2f°) = %.4f%n", degrees, values[0]);
        System.out.printf("Cosine(%.2f°) = %.4f%n", degrees, values[1]);
        System.out.printf("Tangent(%.2f°) = %.4f%n", degrees, values[2]);
        scanner.close();
    }
}
