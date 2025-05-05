package com.technogise.foundation.service;

import com.technogise.foundation.exceptions.DuplicateUserException;
import com.technogise.foundation.exceptions.InsufficientBalanceException;
import com.technogise.foundation.exceptions.UserDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletServiceTest {
    private IWalletService walletService;

    @BeforeEach
    void setUp() {
        walletService = new WalletService(new InMemoryTransactionHistoryService());
    }

    @Test
    void shouldRegisterUserSuccessfully() {
        walletService.registerUser("alice");
    }

    @Test
    void shouldNotAllowDuplicateUser() {
        walletService.registerUser("bob");
        assertThrows(DuplicateUserException.class, () -> walletService.registerUser("bob"));
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
