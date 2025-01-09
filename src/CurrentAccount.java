public class CurrentAccount extends BankAccount  {
    private double overdraftLimit;

    public CurrentAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        logTransaction("Deposited: " + amount + ". New balance: " + getBalance());
        System.out.println("Deposited: " + amount + ". New balance: " + getBalance());
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + getOverdraftLimit()) {
            // If the withdrawal is within the balance + overdraft limit
            setBalance(getBalance() - amount);
            logTransaction("Withdrawn: " + amount + ". New balance: " + getBalance());
            System.out.println("Withdrawn: " + amount + ". New balance: " + getBalance());
        }
        else {
            logTransaction("Failed withdrawal attempt of: " + amount + ". Insufficient funds!");
            System.out.println("Insufficient funds for withdrawal!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Account number: " + getAccountNumber() + "\nBalance " + getBalance() + "\nOverdraft limit: " + getOverdraftLimit());
    }

    @Override
    public void showTransactionHistory() {
        if (getTransactionHistory().isEmpty()) {
            System.out.println("No transaction history found.");
            return;
        }

        System.out.println("Transaction History: ");
        for (String transaction : getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}

