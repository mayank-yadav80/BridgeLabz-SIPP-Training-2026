import java.util.InputMismatchException;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {
    public static void main(String[] args) {
        int[] patientCharges = {1200, 1500, 0, 1800};
        String[] billInputs = {"300", "0", "100", "abc"};

        for (int i = 0; i < billInputs.length; i++) {
            try {
                int items = Integer.parseInt(billInputs[i]);
                if (items == 0) {
                    throw new ArithmeticException("Bill has zero items");
                }
                int charge = patientCharges[i];
                int amount = charge / items;
                if (amount > 2000) {
                    throw new InsufficientFundsException("Payment failed: insufficient funds for patient " + i);
                }
                System.out.println("Patient " + i + " bill amount: " + amount);
            } catch (ArithmeticException e) {
                System.out.println("Billing error for patient " + i + ": " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid patient index: " + i);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid billing input for patient " + i + ": please enter a valid number");
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
