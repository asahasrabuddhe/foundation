package com.technogise.foundation.core;

import com.technogise.foundation.exceptions.UnregisteredSymbolException;
import com.technogise.foundation.operations.AddOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationRegistryTest {
    @Test
    void shouldRegisterAndRetrieveOperationBySymbol() {
        OperationRegistry registry = new OperationRegistry();
        Operation add = new AddOperation();
        registry.register(add);

        assertEquals(add, registry.get("+"));
    }

    @Test
    void shouldReturnExceptionForUnregisteredSymbol() {
        OperationRegistry registry = new OperationRegistry();

        assertThrows(UnregisteredSymbolException.class, () -> registry.get("^"));
    }
}
