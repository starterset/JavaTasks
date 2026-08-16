package com.espboorg.designPatterns.strategy.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                double first = sc.nextDouble();
                String sign = sc.next();
                double second = sc.nextDouble();
                Expression ex = new Expression();
                System.out.println("Result: " + ex.produce_result(first, second, sign));
            } catch (InputMismatchException im) {
                System.out.println("Wrong Input");
            } catch (ArithmeticException ae) {
                System.out.println("Please input valid, non-zero divisor");
            }
        }
    }
}
