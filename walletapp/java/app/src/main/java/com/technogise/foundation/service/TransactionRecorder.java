package com.technogise.foundation.service;

import com.technogise.foundation.model.Transaction;

public interface TransactionRecorder {
    void recordTransaction(Transaction transaction);
}
