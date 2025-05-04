package com.technogise.foundation.model;

public class Account {
    private double balance;

    public Account() {
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        balance -= amount;
    }
}
