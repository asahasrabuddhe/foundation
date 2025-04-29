package com.technogise.foundation.parser.lexer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenizerTest {
    @Test
    void testTokenizer() {
        // Basic operations
        assertEquals(List.of("1", "+", "2"), Tokenizer.tokenize("1 + 2"));
        assertEquals(List.of("5.0", "-", "3.0"), Tokenizer.tokenize("5.0 - 3.0"));
        assertEquals(List.of("12.0", "*", "2.0"), Tokenizer.tokenize("12.0 * 2.0"));
        assertEquals(List.of("6.0", "/", "2.0"), Tokenizer.tokenize("6.0 / 2.0"));
        assertEquals(List.of("1", "+", "2", "*", "3"), Tokenizer.tokenize("1 + 2 * 3"));

        // Brackets handling
        assertEquals(List.of("(", "1", "+", "2", ")", "*", "3"), Tokenizer.tokenize("(1 + 2) * 3"));
        assertEquals(List.of("(", "(", "1", "+", "2", ")", "*", "3", ")", "+", "4"), Tokenizer.tokenize("((1 + 2) * 3) + 4"));

        // Extra spaces
        assertEquals(List.of("1", "+", "2"), Tokenizer.tokenize("  1   +  2  "));
        assertEquals(List.of("(", "5", "+", "3", ")", "*", "7"), Tokenizer.tokenize(" ( 5 + 3 ) * 7 "));

        // Decimal numbers with spaces
        assertEquals(List.of("3.5", "+", "2.1"), Tokenizer.tokenize("3.5 + 2.1"));
        assertEquals(List.of("3.5", "*", "2.1", "+", "7.0"), Tokenizer.tokenize("3.5 * 2.1 + 7.0"));

        // Negative numbers (basic tokenizer behavior: it separates "-" and "5")
        assertEquals(List.of("-", "5", "+", "3"), Tokenizer.tokenize("-5 + 3"));
        assertEquals(List.of("4", "*", "-", "2"), Tokenizer.tokenize("4 * -2"));
    }
}
