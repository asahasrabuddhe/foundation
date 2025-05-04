package com.technogise.foundation.exceptions;

public class InsufficientBalanceException extends IllegalArgumentException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
