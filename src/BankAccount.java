import java.util.ArrayList;
import java.util.List;

public abstract  class BankAccount {

    private int accountNumber;
    private double balance;
    private final List<String> transactionHistory;

    // Constructor
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void displayInfo();
    public abstract void showTransactionHistory();

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    protected void logTransaction (String message) {
        transactionHistory.add(message);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

}
