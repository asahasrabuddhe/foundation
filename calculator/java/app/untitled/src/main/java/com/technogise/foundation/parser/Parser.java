package com.technogise.foundation.parser;

import com.technogise.foundation.core.OperationRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parser {
    public static List<String> toPostfix(List<String> tokens, OperationRegistry registry) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (String token: tokens) {
            if(token.matches("^\\d*\\.?\\d*$")) {
                output.add(token);
            } else if (registry.isOperator(token)) {
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }
}
