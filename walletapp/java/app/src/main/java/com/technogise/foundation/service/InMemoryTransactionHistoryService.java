package com.technogise.foundation.service;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTransactionHistoryService implements ITransactionHistoryService {
    private final List<Transaction> transactions;

    public InMemoryTransactionHistoryService() {
        transactions = new ArrayList<>();
    }

    @Override
    public void recordTransaction(Transaction transaction) {
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
