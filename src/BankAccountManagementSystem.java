public class BankAccountManagementSystem {
    public static void main(String[] args) {

        BankService bankService = new BankService();
        InputUtils inputUtils = new InputUtils();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nSimple Bank Account Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money To Another Account");
            System.out.println("5. Check Account Details");
            System.out.println("6. Check Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = inputUtils.readInt();
            switch (choice) {
                case 1:
                    bankService.createAccount();
                    break;
                case 2:
                    bankService.deposit();
                    break;
                case 3:
                    bankService.withdraw();
                    break;
                case 4:
                    bankService.transfer();
                    break;
                case 5:
                    bankService.showDetails();
                    break;
                case 6:
                    bankService.showTransactionHistory();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}