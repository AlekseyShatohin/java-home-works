package ru.qiwi.accounts;

public abstract class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;

    }

    public abstract void getMoney(double amount);

    public double getAmount() {
        return balance;
    }
}
