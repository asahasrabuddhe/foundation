package com.technogise.foundation.calculator;

import com.technogise.foundation.calculator.exception.DivideByZeroException;

public class DivideOperation implements Operation {
    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public double apply(double a, double b) {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a / b;
    }
}
