package task1.codsoft;

import java.util.Scanner;


public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private Account currentAccount;

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }

    public void run() {
        System.out.println("Welcome to the ATM System!");
        if (authenticate()) {
            performOperations();
        }
    }

    public boolean authenticate() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Pin: ");
        String pin = scanner.nextLine();

        Account demoAccount = new Account("12345", "1234", 1000);

        if (demoAccount.getUserId().equals(userId) && demoAccount.getPin().equals(pin)) {
            currentAccount = demoAccount;
            return true;
        } else {
            System.out.println("Invalid user ID or PIN!");
            return false;
        }
    }

    public void performOperations() {
        int choice;
        do {
            System.out.println("\nATM Operations:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : currentAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    public void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (currentAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
        System.out.println("Deposit successful!");
    }

    public void transferMoney() {
        System.out.print("Enter the recipient's User ID: ");
        scanner.nextLine();
        String recipientId = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        Account recipient = new Account("54321", "4321", 500);

        if (currentAccount.transfer(recipient, amount)) {
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Transfer failed!");
        }
    }

}
package task1.codsoft;

import java.util.ArrayList;


public class Account {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            return true;
        }
        return false;
    }

    public boolean transfer(Account toAccount, double amount) {
        if (this.withdraw(amount)) {
            toAccount.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to " + toAccount.getUserId());
            return true;
        }
        return false;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }
}
