// Bank.java
// Manages all bank accounts

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    // Add a new account
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Find account by account number
    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
}

