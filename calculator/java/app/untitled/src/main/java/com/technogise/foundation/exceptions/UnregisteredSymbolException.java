package com.technogise.foundation.exceptions;

public class UnregisteredSymbolException extends RuntimeException {
    public UnregisteredSymbolException(String symbol) {
        super("Symbol " + symbol + " is not registered");
    }
}
