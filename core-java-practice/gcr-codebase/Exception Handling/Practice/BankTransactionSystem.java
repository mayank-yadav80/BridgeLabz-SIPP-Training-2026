import java.util.InputMismatchException;
import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankTransactionSystem {
    private double balance;

    public BankTransactionSystem(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankTransactionSystem account = new BankTransactionSystem(1000.0);
        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
            System.out.println("Withdrawal successful, new balance: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid amount!");
        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance!");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid numeric amount");
        } finally {
            scanner.close();
        }
    }
}
