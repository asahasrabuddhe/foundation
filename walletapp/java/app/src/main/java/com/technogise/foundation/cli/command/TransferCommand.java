package com.technogise.foundation.cli.command;

import com.technogise.foundation.service.MoneyOps;

import java.io.PrintStream;
import java.util.Scanner;

public class TransferCommand implements CommandStrategy {
    private final MoneyOps moneyOps;
    private final Scanner in;
    private final PrintStream out;

    public TransferCommand(MoneyOps moneyOps, Scanner in, PrintStream out) {
        this.moneyOps = moneyOps;
        this.in = in;
        this.out = out;
    }

    @Override
    public void execute() {
        out.print("Enter a user's username: ");
        String from = in.nextLine();
        out.print("Enter the recipient's username: ");
        String to = in.nextLine();
        out.print("Enter amount: ");
        double amount = Double.parseDouble(in.nextLine());
        moneyOps.transfer(from, to, amount);
        out.println("Transfer successful.");
    }

    @Override
    public String getDescription() {
        return "Transfer money to another user";
    }
}
