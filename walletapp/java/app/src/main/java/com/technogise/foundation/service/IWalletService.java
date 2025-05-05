package com.technogise.foundation.service;

import com.technogise.foundation.model.User;

public interface IWalletService {
    void registerUser(User user);
    void topUp(User user, double amount);
    void transfer(User from, User to, double amount);
    double getBalance(User user);
}
