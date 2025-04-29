package com.technogise.foundation.operations;

import com.technogise.foundation.exceptions.DivideByZeroException;
import com.technogise.foundation.core.Operation;

public class DivideOperation implements Operation {
    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public int getPrecedence() {
        return 2;
    }

    @Override
    public double apply(double a, double b) {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a / b;
    }
}
