package com.technogise.foundation.parser;

import com.technogise.foundation.core.OperationRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parser {
    public static List<String> toPostfix(List<String> tokens, OperationRegistry registry) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (token.matches("^\\d*\\.?\\d*$")) {
                output.add(token);
            } else if (registry.isOperator(token)) {
                while (!operators.isEmpty() &&
                        registry.isOperator(operators.peek()) &&
                        registry.get(operators.peek()).getPrecedence() >= registry.get(token).getPrecedence()) {
                    output.add(operators.pop());
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                if (operators.isEmpty()) {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
                operators.pop(); // discard the '('
            } else {
                throw new IllegalArgumentException("Unexpected token: " + token);
            }
        }

        while (!operators.isEmpty()) {
            String operator = operators.pop();
            if (operator.equals("(") || operator.equals(")")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            output.add(operator);
        }

        return output;
    }
}
