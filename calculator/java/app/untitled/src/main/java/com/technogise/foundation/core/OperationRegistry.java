package com.technogise.foundation.core;

import com.technogise.foundation.exceptions.UnregisteredSymbolException;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry {
    private final Map<String, Operation> operations = new HashMap<>();

    public void register(Operation operation) {
        operations.put(operation.getSymbol(), operation);
    }

    public boolean isOperator(String symbol) {
        return operations.containsKey(symbol);
    }

    public Operation get(String symbol) {
        if (!isOperator(symbol)) {
            throw new UnregisteredSymbolException(symbol);
        }
        return operations.get(symbol);
    }
}
