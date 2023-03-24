package ru.qiwi.accounts;

public class PremiumAccount extends BankAccount {

    private final int commission = 1;

    public PremiumAccount(double balance) {
        super(balance);
    }

    @Override
    public void getMoney(double amount) {
        balance -= amount + commission;
    }
}
