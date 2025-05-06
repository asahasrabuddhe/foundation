package com.technogise.foundation.cli.command;

import com.technogise.foundation.service.BalanceEnquiry;

import java.io.PrintStream;
import java.util.Scanner;

public class CheckBalanceCommand implements CommandStrategy {
    private final BalanceEnquiry balanceEnquiry;
    private final Scanner in;
    private final PrintStream out;

    public CheckBalanceCommand(BalanceEnquiry balanceEnquiry, Scanner in, PrintStream out) {
        this.balanceEnquiry = balanceEnquiry;
        this.in = in;
        this.out = out;
    }

    @Override
    public void execute() {
        out.print("Enter username: ");
        String username = in.nextLine();
        double balance = balanceEnquiry.getBalance(username);
        out.println("Balance: " + balance);
    }

    @Override
    public String getDescription() {
        return "Check balance of a user";
    }
} 