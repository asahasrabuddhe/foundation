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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopUpCommandTest {
    @Test
    void shouldTopUpUserSuccessfully() {
        String input = "alice\n100\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        UserRepository userRepository = new InMemoryUserRepository();
        TransactionStore recorder = new InMemoryTransactionStore();
        IWalletService wallet = new WalletService(userRepository, recorder);
        wallet.registerUser("alice");

        CommandStrategy strategy = new TopUpCommand(wallet, new Scanner(in), out);
        strategy.execute();

        assertTrue(outStream.toString().contains("Top-up successful"));
        assertEquals(100, wallet.getBalance("alice"));
    }

}
