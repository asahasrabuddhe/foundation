package com.technogise.foundation.service;

import com.technogise.foundation.exceptions.DuplicateUserException;
import com.technogise.foundation.exceptions.InsufficientBalanceException;
import com.technogise.foundation.exceptions.UserDoesNotExistException;
import com.technogise.foundation.repository.InMemoryTransactionStore;
import com.technogise.foundation.repository.InMemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletServiceTest {
    private IWalletService walletService;
    private InMemoryUserRepository userRepository;
    private InMemoryTransactionStore transactionStore;

    @BeforeEach
    void setUp() {
        userRepository = new InMemoryUserRepository();
        transactionStore = new InMemoryTransactionStore();
        walletService = new WalletService(userRepository, transactionStore);
    }

    @Test
    void shouldRegisterUserSuccessfully() {
        walletService.registerUser("alice");
        assertEquals("alice", walletService.getUser("alice").getUsername());
    }

    @Test
    void shouldNotAllowDuplicateUser() {
        walletService.registerUser("bob");
        assertThrows(DuplicateUserException.class, () -> walletService.registerUser("bob"));
    }

    @Test
    void shouldGetUserSuccessfully() {
        walletService.registerUser("alice");
        assertEquals("alice", walletService.getUser("alice").getUsername());
    }

    @Test
    void shouldFailToGetUserIfUserDoesNotExist() {
        assertThrows(UserDoesNotExistException.class, () -> walletService.getUser("alice"));
    }

    @Test
    void shouldTopUpBalance() {
        walletService.registerUser("alice");
        walletService.topUp("alice", 100);
        assertEquals(100, walletService.getBalance("alice"));
    }

    @Test
    void shouldTopUpBalanceOnlyIfTheUserExists() {
        assertThrows(UserDoesNotExistException.class, () -> walletService.topUp("alice", 100));
    }

    @Test
    void shouldTransferMoneyCorrectly() {
        walletService.registerUser("alice");
        walletService.registerUser("bob");
        walletService.topUp("alice", 100);
        walletService.transfer("alice", "bob", 50);
        assertEquals(50, walletService.getBalance("alice"));
        assertEquals(50, walletService.getBalance("bob"));
    }

    @Test
    void shouldFailTransferIfInsufficientBalance() {
        walletService.registerUser("alice");
        walletService.registerUser("bob");
        assertThrows(
                InsufficientBalanceException.class,
                () -> walletService.transfer("alice", "bob", 100)
        );
    }
}
