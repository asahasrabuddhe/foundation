package com.technogise.foundation.cli.command;

import com.technogise.foundation.service.UserRegistry;

import java.io.PrintStream;
import java.util.Scanner;

public class RegisterUserCommand implements CommandStrategy {
    private final UserRegistry userRegistry;
    private final Scanner in;
    private final PrintStream out;

    public RegisterUserCommand(UserRegistry userRegistry, Scanner in, PrintStream out) {
        this.userRegistry = userRegistry;
        this.in = in;
        this.out = out;
    }

    @Override
    public void execute() {
        out.print("Enter username: ");
        String username = in.nextLine();
        userRegistry.registerUser(username);
        out.println("User registered successfully.");
    }

    @Override
    public String getDescription() {
        return "Register a new user";
    }
} 