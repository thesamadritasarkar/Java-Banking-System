// Account.java
// Represents a single bank account

public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    private String pin;

    // Constructor
    public Account(String accountNumber, String holderName, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Check if entered PIN matches
    public boolean checkPin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs" + amount + " deposited successfully.");
        } else {
            System.out.println(" Invalid deposit amount!");
        }
    }

    // Withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Rs" + amount + " withdrawn successfully.");
            return true;
        } else {
            System.out.println("Insufficient balance!");
            return false;
        }
    }

    // Show balance
    public void showBalance() {
        System.out.println("Current Balance: Rs" + balance);
    }
}
