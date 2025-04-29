package com.technogise.foundation.operations;

import com.technogise.foundation.core.Operation;

public class AddOperation implements Operation {
    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public int getPrecedence() {
        return 1;
    }

    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}
