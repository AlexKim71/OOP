package ua.opnu.java.inheritance.account;

public class BankingAccount {

    private int balance;

    // Конструктор для початкового балансу
    public BankingAccount(Startup s) {
        this.balance = s.getInitialBalance();
    }

    // Додаємо кредит (може бути від’ємний)
    public void credit(Credit c) {
        balance += c.getAmount();
    }

    // Виконуємо дебет (може бути від’ємний)
    public void debit(Debit d) {
        balance += d.getAmount();
    }

    public int getBalance() {
        return balance;
    }
}