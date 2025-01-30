import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to the Banking App!");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Please choose an option: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using the Banking App. Goodbye!");
                    scanner.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to create a new account
    private static void createAccount() {
        scanner.nextLine(); // Consume the newline left by nextInt()
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        BankAccount account = new BankAccount(name);
        accounts.add(account);
        System.out.println("Account created for " + name);
    }

    // Method to deposit money into an existing account
    private static void depositMoney() {
        System.out.print("Enter account holder name: ");
        scanner.nextLine(); // Consume the newline left by nextInt()
        String name = scanner.nextLine();

        BankAccount account = findAccountByName(name);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
        } else {
            System.out.println("Account not found for " + name);
        }
    }

    // Method to withdraw money from an existing account
    private static void withdrawMoney() {
        System.out.print("Enter account holder name: ");
        scanner.nextLine(); // Consume the newline left by nextInt()
        String name = scanner.nextLine();

        BankAccount account = findAccountByName(name);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            account.withdraw(withdrawAmount);
        } else {
            System.out.println("Account not found for " + name);
        }
    }

    // Method to check balance of an existing account
    private static void checkBalance() {
        System.out.print("Enter account holder name: ");
        scanner.nextLine(); // Consume the newline left by nextInt()
        String name = scanner.nextLine();

        BankAccount account = findAccountByName(name);
        if (account != null) {
            account.checkBalance();
        } else {
            System.out.println("Account not found for " + name);
        }
    }

    // Helper method to find account by name
    private static BankAccount findAccountByName(String name) {
        for (BankAccount account : accounts) {
            if (account.getAccountHolder().equalsIgnoreCase(name)) {
                return account;
            }
        }
        return null; // Return null if account not found
    }
}
