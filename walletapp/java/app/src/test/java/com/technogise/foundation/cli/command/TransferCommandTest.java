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

public class TransferCommandTest {
    @Test
    void shouldTransferMoneySuccessfully() {
        String input = "alice\nbob\n50\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);

        UserRepository userRepository = new InMemoryUserRepository();
        TransactionStore recorder = new InMemoryTransactionStore();
        IWalletService wallet = new WalletService(userRepository, recorder);
        wallet.registerUser("alice");
        wallet.registerUser("bob");
        wallet.topUp("alice", 100);

        TransferCommand cmd = new TransferCommand(wallet, scanner, out);
        cmd.execute();

        assertTrue(output.toString().contains("Transfer successful."));
        assertEquals(50, wallet.getBalance("alice"));
        assertEquals(50, wallet.getBalance("bob"));
    }
}
