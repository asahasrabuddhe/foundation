package com.technogise.foundation.model;

import com.technogise.foundation.exceptions.InsufficientBalanceException;
import com.technogise.foundation.exceptions.InvalidCreditAmountException;

public class Account {
    private double balance;

    public Account() {
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        if (amount <= 0) {
            throw new InvalidCreditAmountException("Credit amount should be greater than zero");
        }
        balance += amount;
    }

    public void debit(double amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }
}
