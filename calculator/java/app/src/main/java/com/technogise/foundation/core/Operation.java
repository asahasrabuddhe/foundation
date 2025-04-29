package com.technogise.foundation.core;

public interface Operation {
    String getSymbol(); // e.g. "+", "-"
    int getPrecedence();
    double apply(double a, double b);
}
