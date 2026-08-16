package com.espboorg.designPatterns.strategy.calculator;

import com.espboorg.designPatterns.strategy.calculator.MathOperations.Operation;
import com.espboorg.designPatterns.strategy.calculator.MathOperations.OperationsList;

import java.util.InputMismatchException;
import java.util.List;

public class Expression {

    private Operation resolve(String sign) {
        List<Operation> operations = OperationsList.getOperations();
        for (Operation op : operations) {
            if (op.getSign().equals(sign)) {
                return op;
            }
        }
        return null;
    }

    public double produce_result(double first_operand, double second_operand, String sign) throws InputMismatchException {
        Operation operation = resolve(sign);
        if (operation == null) throw new InputMismatchException("Error sign");
        return operation.operation(first_operand, second_operand);
    }
}
