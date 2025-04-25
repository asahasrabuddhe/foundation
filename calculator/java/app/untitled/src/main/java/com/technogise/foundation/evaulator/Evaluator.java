package com.technogise.foundation.evaulator;

import com.technogise.foundation.core.OperationRegistry;

import java.util.List;
import java.util.Stack;

public class Evaluator {
    public static double evaluate(List<String> postfix, OperationRegistry registry) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (token.matches("^\\d*\\.?\\d*$")) {
                stack.push(Double.parseDouble(token));
            } else {
                double a = stack.pop();
                double b = stack.pop();
                stack.push(registry.get(token).apply(b, a));
            }
        }

        return stack.pop();
    }
}
