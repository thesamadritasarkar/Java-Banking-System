// Main.java
// Entry point of the banking system

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Bank bank = new Bank();

    public static void main(String[] args) {
        System.out.println("Welcome to Simple Banking System");

        while (true) {
            System.out.println("\n========= MAIN MENU =========");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Thank you for using our bank!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Create new account
    static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Deposit: ₹");
        double balance = sc.nextDouble();
        sc.nextLine();

        System.out.print("Set 4-digit PIN: ");
        String pin = sc.nextLine();

        Account acc = new Account(accNo, name, balance, pin);
        bank.addAccount(acc);
        System.out.println("Account created successfully for " + name + "!");
    }

    // Login existing account
    static void login() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        Account acc = bank.findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (!acc.checkPin(pin)) {
            System.out.println("Incorrect PIN!");
            return;
        }

        System.out.println("Login successful! Welcome, " + acc.getHolderName() + "!");

        // Logged-in menu
        while (true) {
            System.out.println("\n------ ACCOUNT MENU ------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ₹");
                    double amt = sc.nextDouble();
                    acc.deposit(amt);
                }
                case 2 -> {
                    System.out.print("Enter withdraw amount: ₹");
                    double amt = sc.nextDouble();
                    acc.withdraw(amt);
                }
                case 3 -> acc.showBalance();
                case 4 -> {
                    System.out.println("Logged out successfully!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
