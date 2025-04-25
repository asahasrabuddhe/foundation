package com.technogise.foundation.tokenizer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenizerTest {
    @Test
    void testTokenizer() {
        assertEquals(List.of("1", "+", "2"), Tokenizer.tokenize("1 + 2"));
        assertEquals(List.of("5.0", "-", "3.0"), Tokenizer.tokenize("5.0 - 3.0"));
        assertEquals(List.of("12.0", "*", "2.0"), Tokenizer.tokenize("12.0 * 2.0"));
        assertEquals(List.of("6.0", "/", "2.0"), Tokenizer.tokenize("6.0 / 2.0"));
        assertEquals(List.of("1", "+", "2", "*", "3"), Tokenizer.tokenize("1 + 2 * 3"));
    }
}
