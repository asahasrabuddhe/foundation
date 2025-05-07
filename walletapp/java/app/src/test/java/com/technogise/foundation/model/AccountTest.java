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
        Account creditedAccount = account.credit(100);
        assertEquals(100, creditedAccount.getBalance());
        assertEquals(0, account.getBalance()); // Original account unchanged
    }

    @Test
    void accountShouldBeDebitedCorrectly() {
        Account account = new Account();
        Account creditedAccount = account.credit(100);
        Account debitedAccount = creditedAccount.debit(30);
        assertEquals(70, debitedAccount.getBalance());
        assertEquals(100, creditedAccount.getBalance()); // Original account unchanged
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
        Account creditedAccount = account.credit(50);
        assertThrows(InsufficientBalanceException.class, () -> creditedAccount.debit(70));
    }
}
