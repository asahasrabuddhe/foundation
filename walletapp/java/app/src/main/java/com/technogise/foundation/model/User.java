package com.technogise.foundation.model;

public class User {
    private final String username;
    private final Account account;

    public User(String username) {
        this.username = username;
        this.account = new Account();
    }

    public String getUsername() {
        return username;
    }

    public Account getAccount() {
        return account;
    }
}
