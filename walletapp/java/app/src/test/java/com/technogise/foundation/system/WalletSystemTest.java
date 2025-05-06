package com.technogise.foundation.system;

import com.technogise.foundation.model.User;
import com.technogise.foundation.service.ITransactionHistoryService;
import com.technogise.foundation.service.IWalletService;
import com.technogise.foundation.service.InMemoryTransactionHistoryService;
import com.technogise.foundation.service.WalletService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletSystemTest {
    @Test
    void shouldRunWalletOperationsEndToEnd() {
        ITransactionHistoryService historyService = new InMemoryTransactionHistoryService();
        IWalletService walletService = new WalletService(historyService);

        walletService.registerUser("alice");
        walletService.registerUser("bob");
        walletService.topUp("alice", 100);
        walletService.transfer("alice", "bob", 40);

        assertEquals(60, walletService.getBalance("alice"));
        assertEquals(40, walletService.getBalance("bob"));

        assertEquals(2, historyService.getAllTransactions().size());

        User alice = walletService.getUser("alice");
        assertEquals(2, historyService.getTransactionsForUser(alice).size());

        User bob = walletService.getUser("bob");
        assertEquals(1, historyService.getTransactionsForUser(bob).size());
    }
}
