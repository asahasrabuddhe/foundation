package com.technogise.foundation.repository;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;

import java.util.List;

public interface TransactionReader {
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsForUser(User user);
}
 