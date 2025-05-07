package com.technogise.foundation.repository;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTransactionStore implements TransactionStore {
    private final List<Transaction> transactions;

    public InMemoryTransactionStore() {
        transactions = new ArrayList<>();
    }

    @Override
    public void record(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public List<Transaction> getTransactionsForUser(User user) {
        return transactions.stream()
                .filter(txn ->
                        txn.getFromUser().equals(user) || txn.getToUser().equals(user)
                )
                .collect(Collectors.toList());
    }
} 