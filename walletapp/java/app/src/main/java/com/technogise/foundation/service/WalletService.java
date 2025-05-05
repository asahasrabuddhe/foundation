package com.technogise.foundation.service;

import com.technogise.foundation.exceptions.DuplicateUserException;
import com.technogise.foundation.exceptions.UserDoesNotExistException;
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
    public void registerUser(String username) {
        if (users.containsKey(username)) {
            throw new DuplicateUserException("User already exists");
        }
        users.put(username, new User(username));
    }

    @Override
    public void topUp(String username, double amount) {
        if (!users.containsKey(username)) {
            throw new UserDoesNotExistException("User " + username + " does not exist");
        }
        users.get(username).getAccount().credit(amount);
    }

    public void transfer(String fromUsername, String toUsername, double amount) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public double getBalance(String username) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
