package com.espboorg.effectiveJava.item6_unnecessaryObjects;

import java.util.regex.Pattern;

public class PerformanceCheck {
    public static void main(String[] args) {
        String fourth = "IV";
        boolean check;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            check = RomanNumeral.isRomanNumeral(fourth);
        }
        System.out.println("String.matches() executed in " + (System.currentTimeMillis() - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; ++i) {
            check = RomanNumerals.isRomanNumeral(fourth);
        }
        System.out.println("Pattern.matcher(s).matches() executed in " + (System.currentTimeMillis() - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        long sum = AllIntegersSum.sumWrapper();
        System.out.println("AllIntegersSum.sumWrapper() executed in " + (System.currentTimeMillis() - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        sum = AllIntegersSum.sumPrimitive();
        System.out.println("AllIntegersSum.sumPrimitive() executed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
    }
}

class RomanNumeral {
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
}

class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}

class AllIntegersSum {
    static long sumWrapper() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    static long sumPrimitive() {
        long sum = 0;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
}
