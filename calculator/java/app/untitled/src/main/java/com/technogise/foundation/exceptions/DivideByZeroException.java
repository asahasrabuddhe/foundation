package com.technogise.foundation.exceptions;

public class DivideByZeroException extends RuntimeException {
    public DivideByZeroException() {
        super("Cannot divide by zero");
    }
}
