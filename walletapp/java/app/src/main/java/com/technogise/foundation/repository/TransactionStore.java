package com.technogise.foundation.repository;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;
import java.util.List;

public interface TransactionStore extends TransactionReader, TransactionRecorder {
    void record(Transaction transaction);
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsForUser(User user);
} 