package com.technogise.foundation.core;

public interface Operation {
    String getSymbol(); // e.g. "+", "-"
    double apply(double a, double b);
}
