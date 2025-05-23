package com.technogise.foundation.operations;

import com.technogise.foundation.exceptions.DivideByZeroException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivideOperationTest {
    @Test
    void testDivideOperation() {
        DivideOperation divideOperation = new DivideOperation();
        assertEquals("/", divideOperation.getSymbol());
        assertEquals(2, divideOperation.getPrecedence());
        assertEquals(3.0, divideOperation.apply(6.0, 2.0));
    }

    @Test
    void testDivideByZeroOperationThrowsErrors() {
        DivideOperation divideOperation = new DivideOperation();
        assertEquals("/", divideOperation.getSymbol());
        assertThrows(DivideByZeroException.class, () -> divideOperation.apply(6.0, 0.0));
    }
}
