package com.technogise.foundation.service;

import com.technogise.foundation.exceptions.DuplicateUserException;
import com.technogise.foundation.exceptions.UserDoesNotExistException;
import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;

import java.util.HashMap;
import java.util.Map;

public class WalletService implements IWalletService {
    private final Map<String, User> users;
    private final TransactionRecorder transactionRecorder;

    public WalletService(TransactionRecorder transactionRecorder) {
        this.transactionRecorder = transactionRecorder;
        this.users = new HashMap<>();
    }

    @Override
    public void registerUser(String username) {
        if (users.containsKey(username)) {
            throw new DuplicateUserException("User " + username + " already exists");
        }
        users.put(username, new User(username));
    }

    @Override
    public User getUser(String username) {
        validateUser(username);
        return users.get(username);
    }

    @Override
    public void topUp(String username, double amount) {
        validateUser(username);

        User user = users.get(username);

        user.getAccount().credit(amount);

        transactionRecorder.recordTransaction(Transaction.topUp(user, amount));
    }

    @Override
    public void transfer(String fromUsername, String toUsername, double amount) {
        validateUser(fromUsername);
        validateUser(toUsername);

        User sender = users.get(fromUsername);
        User receiver = users.get(toUsername);

        sender.getAccount().debit(amount);
        receiver.getAccount().credit(amount);

        transactionRecorder.recordTransaction(Transaction.transfer(sender, receiver, amount));
    }

    @Override
    public double getBalance(String username) {
        validateUser(username);
        return users.get(username).getAccount().getBalance();
    }

    private void validateUser(String username) {
        if (!users.containsKey(username)) {
            throw new UserDoesNotExistException("User " + username + " does not exist");
        }
    }
}
