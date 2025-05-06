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

public class RegisterUserCommandTest {
    @Test
    void shouldRegisterUserSuccessfully() {
        String input = "alice\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        TransactionRecorder recorder = new InMemoryTransactionHistoryService();
        IWalletService wallet = new WalletService(recorder);
        CommandStrategy strategy = new RegisterUserCommand(wallet, new Scanner(in), out);
        strategy.execute();

        assertTrue(outStream.toString().contains("User registered successfully"));
    }
} 