package com.technogise.foundation.cli.command;

import java.io.PrintStream;

public class ExitCommand implements CommandStrategy {
    private final PrintStream out;
    private boolean shouldExit = false;

    public ExitCommand(PrintStream out) {
        this.out = out;
    }

    @Override
    public void execute() {
        out.println("Exiting...");
        shouldExit = true;
    }

    @Override
    public String getDescription() {
        return "Exit the application";
    }

    public boolean shouldExit() {
        return shouldExit;
    }
} 