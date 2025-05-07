package com.technogise.foundation.cli.command;

import com.technogise.foundation.repository.InMemoryTransactionStore;
import com.technogise.foundation.repository.InMemoryUserRepository;
import com.technogise.foundation.repository.TransactionStore;
import com.technogise.foundation.repository.UserRepository;
import com.technogise.foundation.service.IWalletService;
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

        UserRepository userRepository = new InMemoryUserRepository();
        TransactionStore recorder = new InMemoryTransactionStore();
        IWalletService wallet = new WalletService(userRepository, recorder);
        wallet.registerUser("alice");
        wallet.topUp("alice", 100);

        CommandStrategy strategy = new CheckBalanceCommand(wallet, new Scanner(in), out);
        strategy.execute();

        System.out.println(outStream.toString());
        assertTrue(outStream.toString().contains("Balance: 100.0"));
    }
} 