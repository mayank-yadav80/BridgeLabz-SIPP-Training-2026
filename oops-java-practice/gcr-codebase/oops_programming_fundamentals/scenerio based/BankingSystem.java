public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA1001", "Meera Joshi", 15000.0, 4.5);
        CurrentAccount current = new CurrentAccount("CA1001", "Vikram Singh", 12000.0, 0.5);

        savings.deposit(2500.0);
        savings.withdraw(1000.0);
        current.deposit(3500.0);
        current.withdraw(2000.0);

        System.out.println("Bank Account Details");
        System.out.println("-----------------------");
        savings.displayAccountDetails();
        System.out.printf("Calculated Interest: %.2f%n%n", savings.calculateInterest());

        current.displayAccountDetails();
        System.out.printf("Calculated Interest: %.2f%n", current.calculateInterest());
    }
}

abstract class BankAccountBase {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccountBase(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount should be positive.");
            return;
        }
        balance += amount;
        System.out.println(holderName + " deposited " + amount + ". New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount should be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance for " + holderName + ". Requested: " + amount + ", available: " + balance);
            return;
        }
        balance -= amount;
        System.out.println(holderName + " withdrew " + amount + ". New balance: " + balance);
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccountBase {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends BankAccountBase {
    private double monthlyBonusRate;

    public CurrentAccount(String accountNumber, String holderName, double balance, double monthlyBonusRate) {
        super(accountNumber, holderName, balance);
        this.monthlyBonusRate = monthlyBonusRate;
    }

    public double getMonthlyBonusRate() {
        return monthlyBonusRate;
    }

    public void setMonthlyBonusRate(double monthlyBonusRate) {
        this.monthlyBonusRate = monthlyBonusRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * monthlyBonusRate / 100;
    }
}
