package com.technogise.foundation.calculator;

public interface Operation {
    String getSymbol(); // e.g. "+", "-"
    double apply(double a, double b);
}
