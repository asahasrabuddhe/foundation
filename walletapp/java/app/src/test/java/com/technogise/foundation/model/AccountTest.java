package com.technogise.foundation.model;

import com.technogise.foundation.exceptions.InsufficientBalanceException;
import com.technogise.foundation.exceptions.InvalidCreditAmountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    @Test
    void newAccountShouldHaveZeroBalance() {
        Account account = new Account();
        assertEquals(0, account.getBalance());
    }

    @Test
    void accountShouldBeCreditedCorrectly() {
        Account account = new Account();
        account.credit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void accountShouldBeDebitedCorrectly() {
        Account account = new Account();
        account.credit(100);
        account.debit(30);
        assertEquals(70, account.getBalance());
    }

    @Test
    void accountShouldNotAllowCreditingZeroOrNegativeAmount() {
        Account account = new Account();
        assertThrows(InvalidCreditAmountException.class, () -> account.credit(0));
        assertThrows(InvalidCreditAmountException.class, () -> account.credit(-1));
    }

    @Test
    void accountShouldNotAllowDebitingMoreThanBalance() {
        Account account = new Account();
        assertThrows(InsufficientBalanceException.class, () -> account.debit(20));
        account.credit(50);
        assertThrows(InsufficientBalanceException.class, () -> account.debit(70));
    }
}
