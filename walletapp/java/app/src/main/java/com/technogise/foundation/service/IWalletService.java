package com.technogise.foundation.service;

public interface IWalletService {
    void registerUser(String username);
    void topUp(String username, double amount);
    void transfer(String fromUsername, String toUsername, double amount);
    double getBalance(String username);
}
