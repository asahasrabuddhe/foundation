package com.technogise.foundation.cli.command;

import com.technogise.foundation.service.MoneyOps;

import java.io.PrintStream;
import java.util.Scanner;

public class TopUpCommand implements CommandStrategy{
    private final MoneyOps moneyOps;
    private final Scanner in;
    private final PrintStream out;

    public TopUpCommand(MoneyOps moneyOps, Scanner in, PrintStream out) {
        this.moneyOps = moneyOps;
        this.in = in;
        this.out = out;
    }

    @Override
    public void execute() {
        out.print("Enter username: ");
        String username = in.nextLine();
        out.print("Enter amount: ");
        double amount = Double.parseDouble(in.nextLine());
        moneyOps.topUp(username, amount);
        out.println("Top-up successful.");
    }

    @Override
    public String getDescription() {
        return "Top up money into your wallet";
    }
}
