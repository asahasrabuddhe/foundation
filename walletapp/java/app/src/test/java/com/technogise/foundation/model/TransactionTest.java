package com.technogise.foundation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TransactionTest {
    @Test
    void shouldCreateTopUpTransactionCorrectly() {
        User alice = new User("alice");
        Transaction txn = Transaction.topUp(alice, 100);

        assertEquals(Transaction.Type.TOP_UP, txn.getType());
        assertEquals(alice, txn.getFromUser());
        assertEquals(alice, txn.getToUser());
        assertEquals(100, txn.getAmount());
        assertNotNull(txn.getTimestamp());
    }

    @Test
    void shouldCreateTransferTransactionCorrectly() {
        User alice = new User("alice");
        User bob = new User("bob");
        Transaction txn = Transaction.transfer(alice, bob, 100);

        assertEquals(Transaction.Type.TRANSFER, txn.getType());
        assertEquals(alice, txn.getFromUser());
        assertEquals(bob, txn.getToUser());
        assertEquals(100, txn.getAmount());
        assertNotNull(txn.getTimestamp());
    }
}
