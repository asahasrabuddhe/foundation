package com.technogise.foundation.model;

public final class User {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
