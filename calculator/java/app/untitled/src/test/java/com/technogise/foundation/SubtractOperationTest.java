package com.technogise.foundation;

import com.technogise.foundation.calculator.SubtractOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractOperationTest {
    @Test
    void testSubtractOperation() {
        SubtractOperation subtractOperation = new SubtractOperation();
        assertEquals("-", subtractOperation.getSymbol());
        assertEquals(2.0, subtractOperation.apply(5.0, 3.0));
    }
}
