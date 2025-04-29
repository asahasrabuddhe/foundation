package com.technogise.foundation.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractOperationTest {
    @Test
    void testSubtractOperation() {
        SubtractOperation subtractOperation = new SubtractOperation();
        assertEquals("-", subtractOperation.getSymbol());
        assertEquals(1, subtractOperation.getPrecedence());
        assertEquals(2.0, subtractOperation.apply(5.0, 3.0));
    }
}
