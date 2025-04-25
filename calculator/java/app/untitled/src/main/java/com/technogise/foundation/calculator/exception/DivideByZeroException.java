package com.technogise.foundation.calculator.exception;

public class DivideByZeroException extends RuntimeException {
    public DivideByZeroException() {
        super("Cannot divide by zero");
    }
}
