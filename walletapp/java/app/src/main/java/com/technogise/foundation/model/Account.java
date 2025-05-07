package com.technogise.foundation.model;

import com.technogise.foundation.exceptions.InsufficientBalanceException;
import com.technogise.foundation.exceptions.InvalidCreditAmountException;

public final class Account {
    private final double balance;

    public Account() {
        this(0.0);
    }

    private Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public Account credit(double amount) {
        if (amount <= 0) {
            throw new InvalidCreditAmountException("Credit amount should be greater than zero");
        }
        return new Account(balance + amount);
    }

    public Account debit(double amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        return new Account(balance - amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(balance);
    }
}
