package com.espboorg.designPatterns.strategy.calculator.MathOperations;

public final class Division implements Operation {
    private final String DIVIDE = "/";

    Division() {
    }

    @Override
    public String getSign() {
        return DIVIDE;
    }

    @Override
    public double operation(double member_one, double member_two) throws ArithmeticException {
        if (member_two == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return member_one / member_two;
    }
}
