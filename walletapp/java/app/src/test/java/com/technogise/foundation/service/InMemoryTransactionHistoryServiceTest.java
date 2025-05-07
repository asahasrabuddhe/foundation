package com.technogise.foundation.service;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;
import com.technogise.foundation.repository.InMemoryTransactionStore;
import com.technogise.foundation.repository.TransactionStore;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryTransactionHistoryServiceTest {

    @Test
    void shouldRecordAndFetchTransactions() {
        TransactionStore transactionStore = new InMemoryTransactionStore();

        User alice = new User("alice");
        User bob = new User("bob");

        Transaction txn1 = Transaction.topUp(alice, 100);
        Transaction txn2 = Transaction.transfer(alice, bob, 50);

        transactionStore.record(txn1);
        transactionStore.record(txn2);

        List<Transaction> all = transactionStore.getAllTransactions();
        assertEquals(2, all.size());

        List<Transaction> aliceTransactions = transactionStore.getTransactionsForUser(alice);
        assertEquals(2, aliceTransactions.size());
        assertEquals(txn1, aliceTransactions.getFirst());
        assertEquals(txn2, aliceTransactions.getLast());

        List<Transaction> bobTransactions = transactionStore.getTransactionsForUser(bob);
        assertEquals(1, bobTransactions.size());
        assertEquals(txn2, bobTransactions.getFirst());
    }
}
