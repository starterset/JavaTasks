package com.espboorg.designPatterns.strategy.calculator.MathOperations;

public final class Multiplication implements Operation {
    private final String MULTIPLY = "*";

    Multiplication() {
    }

    @Override
    public String getSign() {
        return MULTIPLY;
    }

    @Override
    public double operation(double member_one, double member_two) {
        return member_one * member_two;
    }
}
