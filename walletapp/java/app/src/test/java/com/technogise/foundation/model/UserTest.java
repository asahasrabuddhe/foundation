package com.technogise.foundation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {
    @Test
    void userShouldHaveCorrectUsername() {
        User user = new User("alice");
        assertEquals("alice", user.getUsername());
    }

    @Test
    void userShouldHaveAccount() {
        User user = new User("bob");
        assertNotNull(user.getAccount());
    }
}
