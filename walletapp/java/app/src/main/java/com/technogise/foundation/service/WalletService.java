package com.technogise.foundation.service;

import com.technogise.foundation.exceptions.DuplicateUserException;
import com.technogise.foundation.exceptions.UserDoesNotExistException;
import com.technogise.foundation.model.Account;
import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;
import com.technogise.foundation.repository.TransactionStore;
import com.technogise.foundation.repository.UserRepository;

/**
 * Default implementation of the WalletService interface.
 * Handles user management, money operations, and balance enquiries.
 */
public class WalletService implements IWalletService {
    private final UserRepository userRepository;
    private final TransactionStore transactionStore;

    public WalletService(UserRepository userRepository, TransactionStore transactionStore) {
        this.userRepository = userRepository;
        this.transactionStore = transactionStore;
    }

    @Override
    public void registerUser(String username) {
        if (userRepository.exists(username)) {
            throw new DuplicateUserException("User " + username + " already exists");
        }
        userRepository.save(new User(username));
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserDoesNotExistException("User " + username + " does not exist"));
    }

    @Override
    public void topUp(String username, double amount) {
        User user = getUser(username);

        user.getAccount().credit(amount);

        userRepository.save(user);
        transactionStore.record(Transaction.topUp(user, amount));
    }

    @Override
    public void transfer(String fromUsername, String toUsername, double amount) {
        User sender = getUser(fromUsername);
        User receiver = getUser(toUsername);

        sender.getAccount().debit(amount);
        receiver.getAccount().credit(amount);

        userRepository.save(sender);
        userRepository.save(receiver);

        transactionStore.record(Transaction.transfer(sender, receiver, amount));
    }

    @Override
    public double getBalance(String username) {
        return getUser(username).getAccount().getBalance();
    }
} 