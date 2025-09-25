package ua.opnu;

public class BankAccount {
    // Видалено поле 'name', оскільки воно не використовується
    double balance;
    double transactionFee;

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    double getBalance() {
        return balance;
    }

    boolean withdraw(double amount) {
        if (amount <= 0) return false;
        double totalDeduction = amount + transactionFee;
        if (balance >= totalDeduction) {
            balance -= totalDeduction;
            return true;
        }
        return false;
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0) return false;
        double totalDeduction = amount + transactionFee;
        if (balance >= totalDeduction) {
            balance -= totalDeduction;
            receiver.balance += amount;
            return true;
        }
        return false;
    }
}