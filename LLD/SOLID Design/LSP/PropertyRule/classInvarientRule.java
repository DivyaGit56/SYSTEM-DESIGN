package LSP.PropertyRule;


class BankAccount {
    protected double balance;

    public BankAccount(double b) {
        if (b < 0) throw new IllegalArgumentException("Balance can't be negative");
        balance = b;
    }

    public void withdraw(double amount) {
        if (balance - amount < 0) throw new RuntimeException("Insufficient funds");
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}

// Breaks invariant: Should not be allowed.
class CheatAccount extends BankAccount {
    public CheatAccount(double b) {
        super(b);   //“Call the constructor of BankAccount and pass b to it.”
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount; // LSP break! Negative balance allowed
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}

public class  classInvarientRule {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        bankAccount.withdraw(100);
    }
}