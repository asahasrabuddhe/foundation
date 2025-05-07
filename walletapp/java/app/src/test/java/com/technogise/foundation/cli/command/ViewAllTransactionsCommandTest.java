package com.technogise.foundation.cli.command;

import com.technogise.foundation.repository.InMemoryTransactionStore;
import com.technogise.foundation.repository.InMemoryUserRepository;
import com.technogise.foundation.repository.TransactionStore;
import com.technogise.foundation.repository.UserRepository;
import com.technogise.foundation.service.IWalletService;
import com.technogise.foundation.service.WalletService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewAllTransactionsCommandTest {
    @Test
    void shouldViewAllTransactionsSuccessfully() {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        UserRepository userRepository = new InMemoryUserRepository();
        TransactionStore recorder = new InMemoryTransactionStore();
        IWalletService wallet = new WalletService(userRepository, recorder);
        wallet.registerUser("alice");
        wallet.registerUser("bob");
        wallet.topUp("alice", 100);
        wallet.transfer("alice", "bob", 50);

        CommandStrategy strategy = new ViewAllTransactionsCommand(recorder, out);
        strategy.execute();

        String output = outStream.toString();
        assertTrue(output.contains("All transactions:"));
        assertTrue(output.contains("alice"));
        assertTrue(output.contains("bob"));
        assertTrue(output.contains("50.0"));
    }
} 