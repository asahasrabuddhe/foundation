package com.technogise.foundation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void userShouldHaveCorrectUsername() {
        User user = new User("alice");
        assertEquals("alice", user.getUsername());
    }
}
