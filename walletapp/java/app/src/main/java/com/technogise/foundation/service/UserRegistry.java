package com.technogise.foundation.service;

import com.technogise.foundation.model.User;

public interface UserRegistry {
    void registerUser(String username);
    User getUser(String username);
}
