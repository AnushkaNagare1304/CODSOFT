import java.util.Scanner;

// Class to represent a bank account
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" ₹" + amount + " deposited successfully.");
        } else {
            System.out.println(" Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(" ₹" + amount + " withdrawn successfully.");
            return true;
        } else if (amount > balance) {
            System.out.println(" Insufficient balance!");
        } else {
            System.out.println(" Invalid withdrawal amount!");
        }
        return false;
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM
class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    // Constructor to initialize ATM with user's bank account
    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    // Display ATM menu
    public void displayMenu() {
        while (true) {
            System.out.println("\n🏦 Welcome to ATM");
            System.out.println("1️⃣ Check Balance");
            System.out.println("2️⃣ Deposit Money");
            System.out.println("3️⃣ Withdraw Money");
            System.out.println("4️⃣ Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            handleOption(choice);
        }
    }

    // Handle user option
    private void handleOption(int choice) {
        switch (choice) {
            case 1:
                System.out.println(" Your current balance: ₹" + userAccount.getBalance());
                break;

            case 2:
                System.out.print("Enter deposit amount: ₹");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                break;

            case 3:
                System.out.print("Enter withdrawal amount: ₹");
                double withdrawAmount = scanner.nextDouble();
                userAccount.withdraw(withdrawAmount);
                break;

            case 4:
                System.out.println(" Exiting... Thank you for using our ATM!");
                scanner.close();
                System.exit(0);

            default:
                System.out.println(" Invalid option! Please choose a valid option.");
        }
    }
}

// Main class to run the ATM system
public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000.00); // Initial balance
        ATM atmMachine = new ATM(userAccount);
        atmMachine.displayMenu(); // Start ATM interface
    }
}
