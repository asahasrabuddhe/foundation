package com.technogise.foundation.service;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;

import java.util.List;

public interface ITransactionHistoryService {
    void recordTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsForUser(User user);
}
