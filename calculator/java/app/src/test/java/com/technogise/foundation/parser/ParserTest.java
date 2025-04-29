package com.technogise.foundation.parser;

import com.technogise.foundation.core.OperationRegistry;
import com.technogise.foundation.core.Operation;
import com.technogise.foundation.operations.AddOperation;
import com.technogise.foundation.operations.DivideOperation;
import com.technogise.foundation.operations.MultiplyOperation;
import com.technogise.foundation.operations.SubtractOperation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void shouldRespectOperatorPrecedenceMultiplicationOverAddition() {
        List<String> tokens = List.of("1", "+", "2", "*", "3"); // 1 + 2 * 3
        List<String> result = Parser.toPostfix(tokens, registryWith(new AddOperation(), new MultiplyOperation()));
        List<String> postfix = List.of("1", "2", "3", "*", "+");

        assertEquals(postfix, result);
    }

    @Test
    void shouldRespectEqualPrecedenceLeftToRightForMultiplicationAndDivision() {
        List<String> tokens = List.of("6", "/", "3", "*", "2");
        List<String> result = Parser.toPostfix(tokens, registryWith(
                new MultiplyOperation(), new DivideOperation()));
        List<String> postfix = List.of("6", "3", "/", "2", "*"); // Left to right

        assertEquals(postfix, result);
    }

    @Test
    void shouldRespectEqualPrecedenceLeftToRightForAddAndSubtract() {
        List<String> tokens = List.of("5", "+", "4", "-", "3");
        List<String> result = Parser.toPostfix(tokens, registryWith(
                new AddOperation(), new SubtractOperation()));
        List<String> postfix = List.of("5", "4", "+", "3", "-");

        assertEquals(postfix, result);
    }

    @Test
    void shouldRespectBracketsOverPrecedence() {
        List<String> tokens = List.of("(", "2", "+", "3", ")", "*", "4");
        List<String> result = Parser.toPostfix(tokens, registryWith(
                new AddOperation(), new MultiplyOperation()));
        List<String> expected = List.of("2", "3", "+", "4", "*");

        assertEquals(expected, result);
    }

    @Test
    void shouldHandleNestedBracketsCorrectly() {
        List<String> tokens = List.of("(", "1", "+", "(", "2", "+", "3", ")", ")", "*", "4");
        List<String> result = Parser.toPostfix(tokens, registryWith(
                new AddOperation(), new MultiplyOperation()));
        List<String> expected = List.of("1", "2", "3", "+", "+", "4", "*");

        assertEquals(expected, result);
    }

    @Test
    void shouldHandleMultipleBracketsWithDifferentOperators() {
        List<String> tokens = List.of("(", "6", "+", "2", ")", "*", "(", "3", "-", "1", ")");
        List<String> result = Parser.toPostfix(tokens, registryWith(
                new AddOperation(), new MultiplyOperation(), new SubtractOperation()));
        List<String> expected = List.of("6", "2", "+", "3", "1", "-", "*");

        assertEquals(expected, result);
    }

    @Test
    void shouldThrowIfLeftBracketIsNotClosed() {
        List<String> tokens = List.of("(", "2", "+", "3", "*", "4");

        assertThrows(IllegalArgumentException.class, () ->
                Parser.toPostfix(tokens, registryWith(
                        new AddOperation(), new MultiplyOperation())));
    }

    @Test
    void shouldThrowIfRightBracketIsUnmatched() {
        List<String> tokens = List.of("2", "+", "3", ")", "*", "4");

        assertThrows(IllegalArgumentException.class, () ->
                Parser.toPostfix(tokens, registryWith(
                        new AddOperation(), new MultiplyOperation())));
    }



    private OperationRegistry registryWith(Operation... ops) {
        OperationRegistry reg = new OperationRegistry();
        for (Operation op : ops) {
            reg.register(op);
        }
        return reg;
    }
}
