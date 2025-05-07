package com.technogise.foundation.model;

import com.technogise.foundation.exceptions.InsufficientBalanceException;
import com.technogise.foundation.exceptions.InvalidCreditAmountException;

public final class Account {
    private double balance;

    public Account() {
        balance = 0;
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

    public double getBalance() {
        return balance;
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
