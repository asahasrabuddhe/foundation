package com.technogise.foundation.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddOperationTest {
    @Test
    void testAddOperation() {
        AddOperation addOperation = new AddOperation();
        assertEquals("+", addOperation.getSymbol());
        assertEquals(3.0, addOperation.apply(1.0, 2.0));
    }
}
