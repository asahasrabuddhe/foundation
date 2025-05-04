package com.technogise.foundation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
