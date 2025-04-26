package com.technogise.foundation.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyOperationTest {
    @Test
    void testMultiplyOperation() {
        MultiplyOperation multiplyOperation = new MultiplyOperation();
        assertEquals("*", multiplyOperation.getSymbol());
        assertEquals(12.0, multiplyOperation.apply(6.0, 2.0));
    }
}
