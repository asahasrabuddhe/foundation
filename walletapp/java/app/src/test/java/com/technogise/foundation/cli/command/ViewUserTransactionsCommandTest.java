package com.technogise.foundation.cli.command;

import com.technogise.foundation.service.IWalletService;
import com.technogise.foundation.service.InMemoryTransactionHistoryService;
import com.technogise.foundation.service.TransactionRecorder;
import com.technogise.foundation.service.WalletService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewUserTransactionsCommandTest {
    @Test
    void shouldViewUserTransactionsSuccessfully() {
        String input = "alice\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        InMemoryTransactionHistoryService recorder = new InMemoryTransactionHistoryService();
        IWalletService wallet = new WalletService(recorder);
        wallet.registerUser("alice");
        wallet.registerUser("bob");
        wallet.topUp("alice", 100);
        wallet.transfer("alice", "bob", 50);

        CommandStrategy strategy = new ViewUserTransactionsCommand(recorder, wallet, new Scanner(in), out);
        strategy.execute();

        String output = outStream.toString();
        assertTrue(output.contains("alice"));
        assertTrue(output.contains("bob"));
        assertTrue(output.contains("50.0"));
    }
} 