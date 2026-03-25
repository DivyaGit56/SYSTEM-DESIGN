package LSP;

import java.util.*;

// Deposit capability
interface Depositable {
    void deposit(double amount);
}

// Withdraw capability
interface Withdrawable {
    void withdraw(double amount);
}

// Base account class
abstract class Account {
    protected double balance;

    public double getBalance() {
        return balance;
    }
}

// Saving Account
class SavingAccount extends Account implements Depositable, Withdrawable {

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("SavingAccount deposit: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("SavingAccount withdraw: " + amount);
    }
}

// Current Account
class CurrentAccount extends Account implements Depositable, Withdrawable {

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("CurrentAccount deposit: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount; // overdraft allowed
        System.out.println("CurrentAccount withdraw: " + amount);
    }
}

// Fixed Deposit Account (NO withdrawal)
class FixedDepositAccount extends Account implements Depositable {

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("FixedDepositAccount deposit: " + amount);
    }
}

// Main class(BankApplication)
public class LSP {

    // Two separate lists (LSP-safe)
    private static List<Withdrawable> withdrawableAccounts = new ArrayList<>();
    private static List<Depositable> depositOnlyAccounts = new ArrayList<>();

    // Process transactions safely
    static void processTransaction() {

        System.out.println("\n--- Processing Deposits ---");
        for (Depositable acc : depositOnlyAccounts) {
            acc.deposit(1000);
        }

        System.out.println("\n--- Processing Withdrawals ---");
        for (Withdrawable acc : withdrawableAccounts) {
            acc.withdraw(500);
        }
    }

    public static void main(String[] args) {

        SavingAccount sa = new SavingAccount();
        CurrentAccount ca = new CurrentAccount();
        FixedDepositAccount fd = new FixedDepositAccount();

        // Add to lists
        depositOnlyAccounts.add(sa);
        depositOnlyAccounts.add(ca);
        depositOnlyAccounts.add(fd);

        withdrawableAccounts.add(sa);
        withdrawableAccounts.add(ca);
        // fd NOT added here (LSP preserved)

        // Run transactions
        processTransaction();
    }
}