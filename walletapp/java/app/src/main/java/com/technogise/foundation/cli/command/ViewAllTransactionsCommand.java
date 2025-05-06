package com.technogise.foundation.cli.command;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.service.TransactionReader;

import java.io.PrintStream;
import java.util.Scanner;

public class ViewAllTransactionsCommand implements CommandStrategy {
    private final TransactionReader transactionReader;
    private final PrintStream out;

    public ViewAllTransactionsCommand(TransactionReader transactionReader, PrintStream out) {
        this.transactionReader = transactionReader;
        this.out = out;
    }

    @Override
    public void execute() {
        out.println("All transactions:");
        transactionReader.getAllTransactions().forEach(this::printTransaction);
    }

    @Override
    public String getDescription() {
        return "View all transactions";
    }

    private void printTransaction(Transaction txn) {
        out.printf("[%s] %s -> %s : %f\n", 
            txn.getTimestamp(), 
            txn.getFromUser().getUsername(), 
            txn.getToUser().getUsername(), 
            txn.getAmount());
    }
} 