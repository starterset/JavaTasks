package com.espboorg.designPatterns.strategy.calculator.MathOperations;

import java.util.ArrayList;
import java.util.List;

public class OperationsList extends ArrayList<Operation> {

    // Create an object of OperationsListCreator
    private static final OperationsList instance = new OperationsList();

    // Private constructor
    private OperationsList() {
    }

    // Get the only object
    public static List<Operation> getOperations() {
        instance.add(new Addition());
        instance.add(new Subtraction());
        instance.add(new Multiplication());
        instance.add(new Division());
        return instance;
    }
}
