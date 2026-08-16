package com.espboorg.designPatterns.strategy.calculator.MathOperations;

public final class Subtraction implements Operation {
    private final String MINUS = "-";

    Subtraction() {
    }

    @Override
    public String getSign() {
        return MINUS;
    }

    @Override
    public double operation(double member_one, double member_two) {
        return member_one - member_two;
    }
}
