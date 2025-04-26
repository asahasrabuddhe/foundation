package com.technogise.foundation.core;

import com.technogise.foundation.operations.AddOperation;
import com.technogise.foundation.operations.MultiplyOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void shouldCalculateSimpleAddition() {
        OperationRegistry registry = new OperationRegistry();
        registry.register(new AddOperation());
        registry.register(new MultiplyOperation());

        Calculator calculator = new Calculator(registry);

        double result = calculator.calculate("1 + 2");
        assertEquals(3, result);
    }
}
