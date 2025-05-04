package com.technogise.foundation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    @Test
    void newAccountShouldHaveZeroBalance() {
        Account account = new Account();
        assertEquals(0, account.getBalance());
    }
}
