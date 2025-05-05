package com.technogise.foundation.exceptions;

public class UserDoesNotExistException extends IllegalArgumentException {
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
