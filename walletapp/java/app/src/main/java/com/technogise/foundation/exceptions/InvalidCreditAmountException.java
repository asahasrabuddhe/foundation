package com.technogise.foundation.exceptions;

public class InvalidCreditAmountException extends IllegalArgumentException {
    public InvalidCreditAmountException(String message) {
        super(message);
    }
}
