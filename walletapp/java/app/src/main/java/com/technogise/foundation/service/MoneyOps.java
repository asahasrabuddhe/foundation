package com.technogise.foundation.service;

public interface MoneyOps {
    void topUp(String username, double amount);
    void transfer(String fromUsername, String toUsername, double amount);
}
