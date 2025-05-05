package com.technogise.foundation.service;

import com.technogise.foundation.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
