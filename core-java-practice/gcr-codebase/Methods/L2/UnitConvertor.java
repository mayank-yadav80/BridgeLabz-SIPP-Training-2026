import java.util.Scanner;

public class UnitConvertor {
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static double convertYardsToFeet(double yards) {
        return yards * 3.0;
    }

    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }

    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }

    public static double convertInchesToCentimeters(double inches) {
        return inches * 2.54;
    }

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unit Convertor Menu:");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Miles to Kilometers");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");
        System.out.println("5. Yards to Feet");
        System.out.println("6. Feet to Yards");
        System.out.println("7. Meters to Inches");
        System.out.println("8. Inches to Meters");
        System.out.println("9. Inches to Centimeters");
        System.out.println("10. Fahrenheit to Celsius");
        System.out.println("11. Celsius to Fahrenheit");
        System.out.println("12. Pounds to Kilograms");
        System.out.println("13. Kilograms to Pounds");
        System.out.println("14. Gallons to Liters");
        System.out.println("15. Liters to Gallons");
        System.out.print("Choose an option (1-15): ");
        int option = scanner.nextInt();
        System.out.print("Enter the value to convert: ");
        double value = scanner.nextDouble();
        double converted = 0;
        switch (option) {
            case 1:
                converted = convertKmToMiles(value);
                System.out.printf("%.4f kilometers = %.4f miles%n", value, converted);
                break;
            case 2:
                converted = convertMilesToKm(value);
                System.out.printf("%.4f miles = %.4f kilometers%n", value, converted);
                break;
            case 3:
                converted = convertMetersToFeet(value);
                System.out.printf("%.4f meters = %.4f feet%n", value, converted);
                break;
            case 4:
                converted = convertFeetToMeters(value);
                System.out.printf("%.4f feet = %.4f meters%n", value, converted);
                break;
            case 5:
                converted = convertYardsToFeet(value);
                System.out.printf("%.4f yards = %.4f feet%n", value, converted);
                break;
            case 6:
                converted = convertFeetToYards(value);
                System.out.printf("%.4f feet = %.4f yards%n", value, converted);
                break;
            case 7:
                converted = convertMetersToInches(value);
                System.out.printf("%.4f meters = %.4f inches%n", value, converted);
                break;
            case 8:
                converted = convertInchesToMeters(value);
                System.out.printf("%.4f inches = %.4f meters%n", value, converted);
                break;
            case 9:
                converted = convertInchesToCentimeters(value);
                System.out.printf("%.4f inches = %.4f centimeters%n", value, converted);
                break;
            case 10:
                converted = convertFahrenheitToCelsius(value);
                System.out.printf("%.4f °F = %.4f °C%n", value, converted);
                break;
            case 11:
                converted = convertCelsiusToFahrenheit(value);
                System.out.printf("%.4f °C = %.4f °F%n", value, converted);
                break;
            case 12:
                converted = convertPoundsToKilograms(value);
                System.out.printf("%.4f pounds = %.4f kilograms%n", value, converted);
                break;
            case 13:
                converted = convertKilogramsToPounds(value);
                System.out.printf("%.4f kilograms = %.4f pounds%n", value, converted);
                break;
            case 14:
                converted = convertGallonsToLiters(value);
                System.out.printf("%.4f gallons = %.4f liters%n", value, converted);
                break;
            case 15:
                converted = convertLitersToGallons(value);
                System.out.printf("%.4f liters = %.4f gallons%n", value, converted);
                break;
            default:
                System.out.println("Invalid option selected.");
        }
        scanner.close();
    }
}
