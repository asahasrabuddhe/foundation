package com.technogise.foundation.cli;

 import com.technogise.foundation.cli.command.*;
import com.technogise.foundation.service.*;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WalletCLI {
    private final Map<Integer, CommandStrategy> commands;
    private final Scanner scanner;
    private final PrintStream out;

    public WalletCLI(UserRegistry userRegistry, MoneyOps moneyOps, BalanceEnquiry balanceEnquiry, TransactionReader transactionReader) {
        this.scanner = new Scanner(System.in);
        this.out = System.out;
        this.commands = new HashMap<>();
        
        // Initialize commands
        commands.put(1, new RegisterUserCommand(userRegistry, scanner, out));
        commands.put(2, new TopUpCommand(moneyOps, scanner, out));
        commands.put(3, new TransferCommand(moneyOps, scanner, out));
        commands.put(4, new CheckBalanceCommand(balanceEnquiry, scanner, out));
        commands.put(5, new ViewAllTransactionsCommand(transactionReader, out));
        commands.put(6, new ViewUserTransactionsCommand(transactionReader, userRegistry, scanner, out));
        commands.put(7, new ExitCommand(out));
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                CommandStrategy command = commands.get(choice);
                if (command != null) {
                    command.execute();
                    if (command instanceof ExitCommand exitCommand && exitCommand.shouldExit()) {
                        return;
                    }
                } else {
                    out.println("Invalid option");
                }
            } catch (Exception ex) {
                out.println("Error: " + ex.getMessage());
            }
        }
    }

    private void printMenu() {
        out.println("\nWelcome to Wallet CLI");
        out.println("Please choose an option:");
        commands.forEach((key, command) -> 
            out.printf("%d. %s%n", key, command.getDescription()));
    }
}

