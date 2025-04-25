package com.technogise.foundation.core;

import com.technogise.foundation.exceptions.UnregisteredSymbolException;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry {
    private final Map<String, Operation> operations = new HashMap<>();

    public void register(Operation operation) {
        operations.put(operation.getSymbol(), operation);
    }

    public Operation get(String symbol) {
        if (!operations.containsKey(symbol)) {
            throw new UnregisteredSymbolException(symbol);
        }
        return operations.get(symbol);
    }
}
