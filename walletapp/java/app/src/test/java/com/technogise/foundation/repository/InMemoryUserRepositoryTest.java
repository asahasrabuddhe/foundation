package com.technogise.foundation.repository;

import com.technogise.foundation.model.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryUserRepositoryTest {
    private final UserRepository repository = new InMemoryUserRepository();

    @Test
    void shouldSaveAndFindUser() {
        User user = new User("alice");
        repository.save(user);

        Optional<User> found = repository.findByUsername("alice");
        assertTrue(found.isPresent());
        assertEquals("alice", found.get().getUsername());
    }

    @Test
    void shouldReturnEmptyWhenUserNotFound() {
        Optional<User> found = repository.findByUsername("nonexistent");
        assertTrue(found.isEmpty());
    }

    @Test
    void shouldCheckIfUserExists() {
        User user = new User("bob");
        repository.save(user);

        assertTrue(repository.exists("bob"));
        assertFalse(repository.exists("nonexistent"));
    }
} 