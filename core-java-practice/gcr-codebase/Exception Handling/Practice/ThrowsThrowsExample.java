public class ThrowsThrowsExample {
    public static void main(String[] args) {
        try {
            double interest = calculateInterest(1000, 5, 2);
            System.out.println("Calculated interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }

    private static double calculateInterest(double amount, double rate, int years) {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Negative amount or rate not allowed");
        }
        return amount * rate * years / 100.0;
    }
}
