package BankManagementSystem;

import java.util.HashMap;

public class BankManager {
    private HashMap<Long, BankAccount> accounts = new HashMap<>();

    // Create a new account and return it
    public BankAccount createAccount(long accountNo, String name, double initialBalance) {
        BankAccount account = new BankAccount(accountNo, name, initialBalance, 0);
        accounts.put(accountNo, account);
        System.out.println("Account created successfully for " + name + " with account number: " + accountNo);
        return account;
    }

    // Get an existing account
    public BankAccount getAccount(long accountNo) {
        return accounts.get(accountNo);
    }

    // Check if an account exists
    public boolean accountExists(long accountNo) {
        return accounts.containsKey(accountNo);
    }
}
