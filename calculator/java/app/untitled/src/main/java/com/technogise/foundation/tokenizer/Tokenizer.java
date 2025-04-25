package com.technogise.foundation.tokenizer;

import java.util.Arrays;
import java.util.List;

public class Tokenizer  {
    public static List<String> tokenize(String expression) {
        return Arrays.asList(expression.replaceAll("([+\\-*])", " $1 ").trim().split("\\s+"));
    }
}
