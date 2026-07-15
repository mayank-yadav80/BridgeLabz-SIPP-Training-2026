class InsufficientBalanceException extends Exception {
    private final double requestedAmount;
    private final double availableBalance;

    public InsufficientBalanceException(double requestedAmount, double availableBalance) {
        super("Withdrawal failed: requested " + requestedAmount + " but available balance is " + availableBalance);
        this.requestedAmount = requestedAmount;
        this.availableBalance = availableBalance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }
}

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        double balance = 5000.0;
        double withdrawalAmount = 8000.0;

        try {
            processWithdrawal(balance, withdrawalAmount);
            System.out.println("Withdrawal successful");
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
            System.out.println("Handle this exception in the withdrawal layer and notify the customer.");
        }
    }

    public static void processWithdrawal(double balance, double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(amount, balance);
        }
    }
}
