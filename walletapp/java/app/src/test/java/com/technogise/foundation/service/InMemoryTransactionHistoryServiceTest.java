package com.technogise.foundation.service;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryTransactionHistoryServiceTest {

    @Test
    void shouldRecordAndFetchTransactions() {
        ITransactionHistoryService transactionHistoryService = new InMemoryTransactionHistoryService();

        User alice = new User("alice");
        User bob = new User("bob");

        Transaction txn1 = Transaction.topUp(alice, 100);
        Transaction txn2 = Transaction.transfer(alice, bob, 50);

        transactionHistoryService.recordTransaction(txn1);
        transactionHistoryService.recordTransaction(txn2);

        List<Transaction> all = transactionHistoryService.getAllTransactions();
        assertEquals(2, all.size());

        List<Transaction> aliceTransactions = transactionHistoryService.getTransactionsForUser(alice);
        assertEquals(2, aliceTransactions.size());
        assertEquals(txn1, aliceTransactions.getFirst());
        assertEquals(txn2, aliceTransactions.getLast());

        List<Transaction> bobTransactions = transactionHistoryService.getTransactionsForUser(bob);
        assertEquals(1, bobTransactions.size());
        assertEquals(txn2, bobTransactions.getFirst());
    }
}
