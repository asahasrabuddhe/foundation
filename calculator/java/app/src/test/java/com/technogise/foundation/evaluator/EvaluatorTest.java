package com.technogise.foundation.evaluator;

import com.technogise.foundation.core.OperationRegistry;
import com.technogise.foundation.evaulator.Evaluator;
import com.technogise.foundation.operations.AddOperation;
import com.technogise.foundation.operations.DivideOperation;
import com.technogise.foundation.operations.MultiplyOperation;
import com.technogise.foundation.operations.SubtractOperation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluatorTest {
    @Test
    void shouldEvaluateAddOperation() {
        List<String> postfix = List.of("1", "2", "+");
        OperationRegistry registry = new OperationRegistry();
        registry.register(new AddOperation());

        double result = Evaluator.evaluate(postfix, registry);

        assertEquals(3.0, result);
    }

    @Test
    void shouldEvaluateSubtractOperation() {
        List<String> postfix = List.of("5", "3", "-");
        OperationRegistry registry = new OperationRegistry();
        registry.register(new SubtractOperation());

        double result = Evaluator.evaluate(postfix, registry);

        assertEquals(2.0, result);
    }

    @Test
    void shouldEvaluateMultiplyOperation() {
        List<String> postfix = List.of("6", "2", "*");
        OperationRegistry registry = new OperationRegistry();
        registry.register(new MultiplyOperation());

        double result = Evaluator.evaluate(postfix, registry);

        assertEquals(12.0, result);
    }

    @Test
    void shouldEvaluateDivideOperation() {
        List<String> postfix = List.of("6", "2", "/");
        OperationRegistry registry = new OperationRegistry();
        registry.register(new DivideOperation());

        double result = Evaluator.evaluate(postfix, registry);

        assertEquals(3.0, result);
    }
}
