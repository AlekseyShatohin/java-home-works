package ru.qiwi.accounts;

public class SimpleAccount extends BankAccount {

    private final double commission = 0.05;

    public SimpleAccount(double balance) {
        super(balance);
    }

    @Override
    public void getMoney(double amount) {
        balance -= amount + amount * commission;
    }
}
