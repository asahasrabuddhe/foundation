package com.technogise.foundation.exceptions;

public class DuplicateUserException extends IllegalArgumentException {
    public DuplicateUserException(String message) {
        super(message);
    }
}
