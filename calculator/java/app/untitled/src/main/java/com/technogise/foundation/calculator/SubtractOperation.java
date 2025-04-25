package com.technogise.foundation.calculator;

public class SubtractOperation implements Operation {
    @Override
    public String getSymbol() {
        return "-";
    }

    @Override
    public double apply(double a, double b) {
        return a - b;
    }
}
