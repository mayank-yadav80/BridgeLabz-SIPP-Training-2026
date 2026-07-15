import java.util.Scanner;

public class QuadraticRoots {
    public static double[] findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            return new double[0];
        }
        if (delta == 0) {
            return new double[]{-b / (2 * a)};
        }
        return new double[]{(-b + Math.sqrt(delta)) / (2 * a), (-b - Math.sqrt(delta)) / (2 * a)};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
        if (a == 0) {
            System.out.println("Coefficient a cannot be zero for a quadratic equation.");
        } else {
            double[] roots = findRoots(a, b, c);
            if (roots.length == 0) {
                System.out.println("No real roots exist.");
            } else if (roots.length == 1) {
                System.out.printf("One real root: %.4f%n", roots[0]);
            } else {
                System.out.printf("Root 1: %.4f%n", roots[0]);
                System.out.printf("Root 2: %.4f%n", roots[1]);
            }
        }
        scanner.close();
    }
}
