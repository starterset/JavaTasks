package com.espboorg.competitive.hackerrank._16_01_22;

/*
    Fib  |1 1 2 3 5 8 13.....
    Index|0 1 2 3 4 5 6 .....
    -------------------------
    Fib(Index) =
    Fib(6) = 13
    Fib(0) = 1
    -------------------------
    int fib(int index) {}
    -------------------------
    1. Loop
    2. Recuresion.
*/

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibLoop(5));
        System.out.println(fibRecursion(6));
    }

    public static int fibLoop(int index) {
        if (index == 0 || index == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        for (int i = 2; i <= index; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public static int fibRecursion(int index) {
        if (index == 0 || index == 1) {
            return 1;
        }
        return fibRecursion(index - 1) + fibRecursion(index - 2);
    }
}
