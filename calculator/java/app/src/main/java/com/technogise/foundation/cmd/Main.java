package com.technogise.foundation.cmd;

import com.technogise.foundation.core.Calculator;
import com.technogise.foundation.core.OperationRegistry;
import com.technogise.foundation.operations.AddOperation;
import com.technogise.foundation.operations.DivideOperation;
import com.technogise.foundation.operations.MultiplyOperation;
import com.technogise.foundation.operations.SubtractOperation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OperationRegistry registry = new OperationRegistry();

        registry.register(new AddOperation());
        registry.register(new SubtractOperation());
        registry.register(new MultiplyOperation());
        registry.register(new DivideOperation());

        Calculator calculator = new Calculator(registry);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an expression:");
        String input = scanner.nextLine();

        try {
            double result = calculator.calculate(input);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
