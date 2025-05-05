package com.technogise.foundation.service;

import com.technogise.foundation.exceptions.DuplicateUserException;
import com.technogise.foundation.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletServiceTest {
    private IWalletService walletService;

    @BeforeEach
    void setUp() {
        walletService = new WalletService(new InMemoryTransactionHistoryService());
    }

    @Test
    void shouldRegisterUserSuccessfully() {
        User alice = new User("alice");
        walletService.registerUser(alice);
    }

    @Test
    void shouldNotAllowDuplicateUser() {
        User bob = new User("bob");
        walletService.registerUser(bob);
        assertThrows(DuplicateUserException.class, () -> walletService.registerUser(new User("bob")));
    }
}
