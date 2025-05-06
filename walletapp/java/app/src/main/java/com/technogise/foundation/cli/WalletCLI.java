package com.technogise.foundation.cli;

import com.technogise.foundation.model.Transaction;
import com.technogise.foundation.model.User;
import com.technogise.foundation.service.ITransactionHistoryService;
import com.technogise.foundation.service.IWalletService;

import java.util.Scanner;

public class WalletCLI {
    private final IWalletService walletService;
    private final ITransactionHistoryService transactionHistoryService;
    private Scanner scanner;

    public WalletCLI(IWalletService walletService, ITransactionHistoryService transactionHistoryService) {
        this.walletService = walletService;
        this.transactionHistoryService = transactionHistoryService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWelcome to Wallet CLI");
            System.out.println("Please choose an option:");
            System.out.println("1. Register a user");
            System.out.println("2. Top up money into your wallet");
            System.out.println("3. Transfer money to another user");
            System.out.println("4. Check balance");
            System.out.println("5. View all transactions");
            System.out.println("6. View user's transactions");
            System.out.println("7. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1 -> registerUser();
                    case 2 -> topUp();
                    case 3 -> transferMoney();
                    case 4 -> checkBalance();
                    case 5 -> viewAllTransactions();
                    case 6 -> viewUserTransactions();
                    case 7 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    private void registerUser() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        walletService.registerUser(username);
        System.out.println("User registered successfully.");
    }

    private void topUp() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        walletService.topUp(username, amount);
        System.out.println("Top up successful.");
    }

    private void transferMoney() {
        System.out.println("Enter username:");
        String fromUsername = scanner.nextLine();
        System.out.println("Enter recipient's username:");
        String toUsername = scanner.nextLine();
        System.out.println("Enter amount:");
        double amount = Double.parseDouble(scanner.nextLine());
        walletService.transfer(fromUsername, toUsername, amount);
        System.out.println("Transfer successful.");
    }

    private void checkBalance() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        double balance = walletService.getBalance(username);
        System.out.println("Balance: " + balance);
    }

    private void viewAllTransactions() {
        System.out.println("All transactions:");
        transactionHistoryService.getAllTransactions().forEach(this::printTransaction);
    }

    private void viewUserTransactions() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        User user = walletService.getUser(username);
        transactionHistoryService.getTransactionsForUser(user).forEach(this::printTransaction);
    }

    private void printTransaction(Transaction txn) {
        System.out.printf("[%s] %s -> %s : %f\n", txn.getTimestamp(), txn.getFromUser().getUsername(), txn.getToUser().getUsername(), txn.getAmount());
    }
}

