package com.espboorg.designPatterns.strategy.calculator.MathOperations;

public interface Operation {
    String getSign();

    double operation(double member_one, double member_two);
}
