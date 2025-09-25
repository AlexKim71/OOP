package ua.opnu;

public class Main {
    public static void main(String[] args) {
        // Приклад використання класів
        TimeSpan time = new TimeSpan(2, 30);
        System.out.println("Total hours: " + time.getTotalHours()); // 2.5

        BankAccount account = new BankAccount();
        account.balance = 1000;
        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance()); // 1500
    }
}