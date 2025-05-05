package com.technogise.foundation.model;

import java.time.LocalDateTime;

public class Transaction {
    public enum Type {
        TOP_UP, TRANSFER
    }

    private final Type type;
    private final User from;
    private final User to;
    private final double amount;
    private final LocalDateTime timestamp;

    private Transaction(Type type, User from, User to, double amount) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public static Transaction topUp(User user, double amount) {
        return new Transaction(Type.TOP_UP, user, user, amount);
    }

    public static Transaction transfer(User from, User to, double amount) {
        return new Transaction(Type.TRANSFER, from, to, amount);
    }

    public Type getType() {
        return type;
    }

    public User getFromUser() {
        return from;
    }

    public User getToUser() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
