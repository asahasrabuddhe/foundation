package com.technogise.foundation.service;

import com.technogise.foundation.model.User;

import java.util.HashMap;
import java.util.Map;

public class WalletService implements IWalletService {
    private final Map<String, User> users;
    private final ITransactionHistoryService transactionHistoryService;

    public WalletService(ITransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
        this.users = new HashMap<>();
    }

    @Override
    public void registerUser(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public void topUp(User user, double amount) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void transfer(User from, User to, double amount) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public double getBalance(User user) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
