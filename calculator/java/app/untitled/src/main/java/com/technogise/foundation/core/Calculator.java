package com.technogise.foundation.core;

import com.technogise.foundation.evaulator.Evaluator;
import com.technogise.foundation.parser.Parser;
import com.technogise.foundation.parser.lexer.Tokenizer;

import java.util.List;

public class Calculator {
    public final OperationRegistry registry;

    public Calculator(OperationRegistry registry) {
        this.registry = registry;
    }

    public double calculate(String expression) {
        List<String> tokens = Tokenizer.tokenize(expression);
        List<String> postfix = Parser.toPostfix(tokens, registry);

        return Evaluator.evaluate(postfix, registry);
    }
}
