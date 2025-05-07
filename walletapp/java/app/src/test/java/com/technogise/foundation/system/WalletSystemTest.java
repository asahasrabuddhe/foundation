package com.technogise.foundation.system;

import com.technogise.foundation.model.User;
import com.technogise.foundation.repository.InMemoryTransactionStore;
import com.technogise.foundation.repository.InMemoryUserRepository;
import com.technogise.foundation.repository.TransactionStore;
import com.technogise.foundation.repository.UserRepository;
import com.technogise.foundation.service.IWalletService;
import com.technogise.foundation.service.WalletService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletSystemTest {
    @Test
    void shouldRunWalletOperationsEndToEnd() {
        UserRepository userRepository = new InMemoryUserRepository();
        TransactionStore transactionStore = new InMemoryTransactionStore();
        IWalletService walletService = new WalletService(userRepository, transactionStore);

        walletService.registerUser("alice");
        walletService.registerUser("bob");
        walletService.topUp("alice", 100);
        walletService.transfer("alice", "bob", 40);

        assertEquals(60, walletService.getBalance("alice"));
        assertEquals(40, walletService.getBalance("bob"));

        assertEquals(2, transactionStore.getAllTransactions().size());

        User alice = walletService.getUser("alice");
        assertEquals(2, transactionStore.getTransactionsForUser(alice).size());

        User bob = walletService.getUser("bob");
        assertEquals(1, transactionStore.getTransactionsForUser(bob).size());
    }
}
