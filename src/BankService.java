import java.util.*;

public class BankService {

    // Collection to store all bank accounts
    private Map<Integer, BankAccount> accounts;
    private InputUtils inputUtils;

    // Constructor
    public BankService() {
        this.accounts = new HashMap<>();
        this.inputUtils = new InputUtils();
    }


    //Create Account
    public void createAccount() {
        System.out.println("Enter account number: ");
        int accountNumber = inputUtils.readInt();
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account number already exists!");
            return;
        }
        System.out.println("Enter initial balance: ");
        double balance = inputUtils.readDouble();

        System.out.println("Select account type: ");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter your choice: ");
        int accountType = inputUtils.readInt();

        switch (accountType) {
            case 1:
                BankAccount newSavingAccount = new SavingsAccount(accountNumber, balance, 2.5);
                accounts.put(accountNumber, newSavingAccount);
                break;
            case 2:
                System.out.println("Enter your overdraft limit: ");
                double overdraftLimit = inputUtils.readDouble();
                BankAccount newCurrentAccount = new CurrentAccount(accountNumber, balance, overdraftLimit);
                accounts.put(accountNumber, newCurrentAccount);
                break;
            default:
                System.out.println("Invalid account type.");
                break;
        }
        System.out.println("Account: " + accountNumber + " created successfully.");
    }


    // Method to deposit money into an account
    public void deposit() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = inputUtils.readDouble();
            account.deposit(amount);
        }
    }

    // Method to withdraw money from an account
    public void withdraw() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.println("Enter amount to withdraw: ");
            double amount = inputUtils.readDouble();
            account.withdraw(amount);
        }
    }

    // Method to transfer money between two accounts
    public void transfer() {
        // Get the source account
        BankAccount fromAccount = findAccount();
        if (fromAccount == null) {
            System.out.println("Source account not found!");
            return;
        }

        // Get the amount to transfer
        System.out.print("Enter amount to transfer: ");
        double amount = inputUtils.readDouble();

        // Check if the source account has enough balance
        if (fromAccount.getBalance() < amount) {
            System.out.println("Insufficient funds in the source account!");
            return;
        }

        // Perform withdrawal from source account
        fromAccount.withdraw(amount);

        // Get the destination account
        BankAccount toAccount = findAccount();
        if (toAccount == null) {
            System.out.println("Destination account not found!");
            // Revert the withdrawal if destination account is not found
            fromAccount.deposit(amount);
            return;
        }

        // Perform deposit to destination account
        toAccount.deposit(amount);

        // Confirm the transfer
        System.out.println("Transfer successful: " + amount + " transferred from Account " + fromAccount.getAccountNumber() + " to Account " + toAccount.getAccountNumber());
    }


    // Method to get details of a specific account
    public void showDetails() {
        BankAccount account = findAccount();
        if (account != null) {
            account.displayInfo();
        }
    }

    public void showTransactionHistory() {
        BankAccount account = findAccount();
        if (account != null) {
            account.showTransactionHistory();
        }
    }

    private BankAccount findAccount() {
        System.out.print("Enter account number: ");
        int accountNumber = inputUtils.readInt();
        for (BankAccount account : accounts.values()) {
            if (account.getAccountNumber() == (accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }


}
