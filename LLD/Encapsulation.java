

public class Encapsulation {

    // 🔒 Encapsulated class
    static class BankAccount {

        // Private data (data hiding)
        private String accountNumber;
        private String accountHolderName;
        private double balance;

        // Constructor
        public BankAccount(String accountNumber, String accountHolderName, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = balance;
        }

        // Getters (controlled access)
        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolderName() {
            return accountHolderName;
        }

        public double getBalance() {
            return balance;
        }

        public void setAccountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
        }

        // Balance should NOT be freely set → business rule applied
        private void setBalance(double balance) {
            this.balance = balance;
        }

        // Business logic
        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid deposit amount");
                return;
            }
            setBalance(balance + amount);
            System.out.println("Amount deposited successfully");
        }


        public void withdraw(double amount) {
            if (amount <= 0 || amount > balance) {
                System.out.println("Invalid withdrawal");
                return;
            }
            setBalance(balance - amount);
            System.out.println("Amount withdrawn successfully");
        }
    }

    // ATM class
    static class ATM {

        public void showBalance(BankAccount account) {
            System.out.println("Current Balance: " + account.getBalance());
        }

        public void depositMoney(BankAccount account, double amount) {
            account.deposit(amount);
        }

        public void withdrawMoney(BankAccount account, double amount) {
            account.withdraw(amount);
        }
    }

    // Main method
    public static void main(String[] args) {

        BankAccount account =
                new BankAccount("123456789", "Divya", 5000);

        ATM atm = new ATM();

        atm.showBalance(account);
        atm.depositMoney(account, 2000);
        atm.withdrawMoney(account, 1000);
        atm.showBalance(account);
        account.setAccountHolderName("Divya Singh");

        atm.showBalance(account);


        
    }
}

