package com.technogise.foundation.repository;

import com.technogise.foundation.model.Transaction;

public interface TransactionRecorder {
    void record(Transaction transaction);
} 