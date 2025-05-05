package com.technogise.foundation.cli;

import com.technogise.foundation.service.ITransactionHistoryService;
import com.technogise.foundation.service.IWalletService;
import com.technogise.foundation.service.InMemoryTransactionHistoryService;
import com.technogise.foundation.service.WalletService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WalletCLITest {
    @Test
    void shouldStartCliAndHandleExitGracefully() {
        String simulatedInput = "1\nalice\n2\nalice\n50\n4\nalice\n7\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ITransactionHistoryService history = new InMemoryTransactionHistoryService();
        IWalletService wallet = new WalletService(history);
        WalletCLI cli = new WalletCLI(wallet, history);

        assertDoesNotThrow(cli::start);
    }
}
