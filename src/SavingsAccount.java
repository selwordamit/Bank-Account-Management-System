public class SavingsAccount extends BankAccount{

    private final double interestRate;

    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = 2.5;
    }

    public double getInterestRate() {
        return interestRate;
    }


    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        double interest = getBalance() * interestRate / 100;
        setBalance(getBalance() + interest);
        logTransaction("Deposited: " + amount + ". Interest added: " + interest + ". New balance: " + getBalance());
        System.out.println("Deposited: " + amount + ". New balance: " + getBalance());
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            logTransaction("Withdrawn: " + amount + ". New balance: " + getBalance());
            System.out.println("Withdrawn: " + amount + ". New balance: " + getBalance());
        } else {
            logTransaction("Failed withdrawal attempt of: " + amount + ". Insufficient funds!");
            System.out.println("Insufficient funds for withdrawal!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Account number: " + getAccountNumber() + "\nBalance " + getBalance() + "\nInterest rate: " + getInterestRate());
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
