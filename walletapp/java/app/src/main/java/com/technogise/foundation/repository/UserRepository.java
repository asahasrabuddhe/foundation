package com.technogise.foundation.repository;

import com.technogise.foundation.model.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    void save(User user);
    boolean exists(String username);
} 