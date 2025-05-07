package com.technogise.foundation.repository;

import com.technogise.foundation.model.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users;

    public InMemoryUserRepository() {
        this.users = new HashMap<>();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }

    @Override
    public void save(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public boolean exists(String username) {
        return users.containsKey(username);
    }
} 