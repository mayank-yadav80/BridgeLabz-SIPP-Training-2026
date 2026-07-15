import java.util.Scanner;

public class WindChillCalculator {
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature - 35.75 * Math.pow(windSpeed, 0.16)
                + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in degrees Fahrenheit: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter wind speed in miles per hour: ");
        double windSpeed = scanner.nextDouble();
        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.printf("The wind chill temperature is %.2f degrees Fahrenheit.%n", windChill);
        scanner.close();
    }
}
