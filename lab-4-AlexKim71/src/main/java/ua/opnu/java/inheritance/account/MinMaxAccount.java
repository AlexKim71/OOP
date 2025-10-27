package ua.opnu.java.inheritance.account;

public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int initialBalance = getBalance();
        this.minBalance = initialBalance;
        this.maxBalance = initialBalance;
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);  // просто викликаємо базовий метод
        updateMinMax();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);  // просто викликаємо базовий метод
        updateMinMax();
    }

    private void updateMinMax() {
        int current = getBalance();
        if (current < minBalance) minBalance = current;
        if (current > maxBalance) maxBalance = current;
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}
