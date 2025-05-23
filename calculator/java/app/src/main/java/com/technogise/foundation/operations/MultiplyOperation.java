package com.technogise.foundation.operations;

import com.technogise.foundation.core.Operation;

public class MultiplyOperation implements Operation {
    @Override
    public String getSymbol() {
        return "*";
    }

    @Override
    public int getPrecedence() {
        return 2;
    }

    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}
