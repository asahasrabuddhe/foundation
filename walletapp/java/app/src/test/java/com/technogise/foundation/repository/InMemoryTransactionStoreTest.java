package com.technogise.foundation.repository;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryTransactionStoreTest {
    private final TransactionStore store = new InMemoryTransactionStore();

    @Test
    void shouldRecordAndFetchTransactions() {
        User alice = new User("alice");
        User bob = new User("bob");

        Transaction txn1 = Transaction.topUp(alice, 100);
        Transaction txn2 = Transaction.transfer(alice, bob, 50);

        store.record(txn1);
        store.record(txn2);

        List<Transaction> all = store.getAllTransactions();
        assertEquals(2, all.size());

        List<Transaction> aliceTransactions = store.getTransactionsForUser(alice);
        assertEquals(2, aliceTransactions.size());
        assertEquals(txn1, aliceTransactions.getFirst());
        assertEquals(txn2, aliceTransactions.getLast());

        List<Transaction> bobTransactions = store.getTransactionsForUser(bob);
        assertEquals(1, bobTransactions.size());
        assertEquals(txn2, bobTransactions.getFirst());
    }
} 