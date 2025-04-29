package com.technogise.foundation.parser;

import com.technogise.foundation.core.OperationRegistry;
import com.technogise.foundation.core.Operation;
import com.technogise.foundation.operations.AddOperation;
import com.technogise.foundation.operations.MultiplyOperation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    void shouldConvertSimpleAdditionToPostfix() {
        List<String> tokens = List.of("1", "+", "2");
        List<String> result = Parser.toPostfix(tokens, registryWith(new AddOperation()));
        List<String> postfix = List.of("1", "2", "+");

        assertEquals(postfix, result);
    }

    @Test
    void shouldParseMultipleOperatorsLeftToRight() {
        List<String> tokens = List.of("1", "+", "2", "*", "3");
        List<String> result = Parser.toPostfix(tokens, registryWith(new AddOperation(), new MultiplyOperation()));
        List<String> postfix = List.of("1", "2", "3", "*", "+");

        assertEquals(postfix, result);
    }

    @Test
    void shouldReturnSingleNumberAsIs() {
        List<String> tokens = List.of("12.0");
        List<String> result = Parser.toPostfix(tokens, registryWith());
        List<String> postfix = List.of("12.0");

        assertEquals(postfix, result);
    }

    private OperationRegistry registryWith(Operation... ops) {
        OperationRegistry reg = new OperationRegistry();
        for (Operation op : ops) {
            reg.register(op);
        }
        return reg;
    }
}
