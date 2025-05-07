package com.technogise.foundation.cli;

import com.technogise.foundation.repository.InMemoryTransactionStore;
import com.technogise.foundation.repository.InMemoryUserRepository;
import com.technogise.foundation.repository.TransactionStore;
import com.technogise.foundation.repository.UserRepository;
import com.technogise.foundation.service.IWalletService;
import com.technogise.foundation.service.WalletService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WalletCLITest {
    @Test
    void shouldStartCliAndHandleExitGracefully() {
        String simulatedInput = "1\nalice\n2\nalice\n50\n4\nalice\n7\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        UserRepository userRepository = new InMemoryUserRepository();
        TransactionStore transactionStore = new InMemoryTransactionStore();
        IWalletService walletService = new WalletService(userRepository, transactionStore);
        WalletCLI cli = new WalletCLI(walletService, walletService, walletService, transactionStore);

        assertDoesNotThrow(cli::start);
    }
}
