public class BankAccount {
    private final String accountNumber;
    private final String holder;
    private double balance;
    private int transactionCount;
    private static int totalAccountsCreated = 0;

    public BankAccount(String accountNumber, String holder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = initialBalance;
        this.transactionCount = 0;
        totalAccountsCreated++;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public static int getTotalAccountsCreated() {
        return totalAccountsCreated;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionCount++;
        System.out.println(holder + " deposited " + amount + ". New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Overdraft prevented for " + holder + ". Requested: " + amount + ", available: " + balance);
            return;
        }
        balance -= amount;
        transactionCount++;
        System.out.println(holder + " withdrew " + amount + ". New balance: " + balance);
    }

    public void getStatement() {
        System.out.println("Account Statement for " + holder + " (" + accountNumber + "):");
        System.out.println("Balance: " + balance);
        System.out.println("Transactions performed: " + transactionCount);
        System.out.println("----");
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("A1001", "Ravi Kumar", 2000.0);
        BankAccount account2 = new BankAccount("A1002", "Sneha Patel", 3500.0);
        BankAccount account3 = new BankAccount("A1003", "Amit Singh", 1500.0);

        account1.deposit(500);
        account1.withdraw(300);
        account1.withdraw(2500);
        account1.deposit(700);
        account1.withdraw(800);

        account2.withdraw(1000);
        account2.deposit(1200);
        account2.withdraw(500);
        account2.withdraw(2500);
        account2.deposit(300);

        account3.deposit(200);
        account3.withdraw(400);
        account3.withdraw(1000);
        account3.deposit(800);
        account3.withdraw(300);

        System.out.println();
        account1.getStatement();
        account2.getStatement();
        account3.getStatement();
        System.out.println("Total accounts created: " + BankAccount.getTotalAccountsCreated());
    }
}