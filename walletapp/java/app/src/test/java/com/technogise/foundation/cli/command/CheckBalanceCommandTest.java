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

public class CheckBalanceCommandTest {
    @Test
    void shouldCheckBalanceSuccessfully() {
        String input = "alice\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        TransactionRecorder recorder = new InMemoryTransactionHistoryService();
        IWalletService wallet = new WalletService(recorder);
        wallet.registerUser("alice");
        wallet.topUp("alice", 100);

        CommandStrategy strategy = new CheckBalanceCommand(wallet, new Scanner(in), out);
        strategy.execute();

        assertTrue(outStream.toString().contains("Balance: 100.0"));
    }
} 