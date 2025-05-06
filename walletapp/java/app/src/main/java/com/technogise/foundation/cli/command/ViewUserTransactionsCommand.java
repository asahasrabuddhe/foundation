package com.technogise.foundation.cli.command;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.service.TransactionReader;
import com.technogise.foundation.service.UserRegistry;

import java.io.PrintStream;
import java.util.Scanner;

public class ViewUserTransactionsCommand implements CommandStrategy {
    private final TransactionReader transactionReader;
    private final UserRegistry userRegistry;
    private final Scanner in;
    private final PrintStream out;

    public ViewUserTransactionsCommand(TransactionReader transactionReader, UserRegistry userRegistry, Scanner in, PrintStream out) {
        this.transactionReader = transactionReader;
        this.userRegistry = userRegistry;
        this.in = in;
        this.out = out;
    }

    @Override
    public void execute() {
        out.print("Enter username: ");
        String username = in.nextLine();
        var user = userRegistry.getUser(username);
        transactionReader.getTransactionsForUser(user).forEach(this::printTransaction);
    }

    @Override
    public String getDescription() {
        return "View user's transactions";
    }

    private void printTransaction(Transaction txn) {
        out.printf("[%s] %s -> %s : %f\n", 
            txn.getTimestamp(), 
            txn.getFromUser().getUsername(), 
            txn.getToUser().getUsername(), 
            txn.getAmount());
    }
} 