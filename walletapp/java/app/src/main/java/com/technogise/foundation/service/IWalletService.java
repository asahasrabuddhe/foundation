package com.technogise.foundation.service;

import com.technogise.foundation.model.User;

public interface IWalletService {
    void registerUser(String username);
    User getUser(String username);
    void topUp(String username, double amount);
    void transfer(String fromUsername, String toUsername, double amount);
    double getBalance(String username);
}
