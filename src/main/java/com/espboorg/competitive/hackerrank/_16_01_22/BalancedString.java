package com.espboorg.competitive.hackerrank._16_01_22;

/*
    Java String
    []
    {}
    ()
    ------------------
    [({})] => this balanced
    [(]) => not balanced
*/

import java.util.Stack;

public class BalancedString {
    public static void main(String[] args) {
        String test = "[{()}]";
        System.out.println(isBalanced(test));
        String test1 = "[(])";
        System.out.println(isBalanced(test1));
    }

    static boolean isBalanced(String str) {
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stringStack.push(str.substring(i, i + 1));
        }

        for (int i = 0; i < str.length() / 2; i++) {
            String top = stringStack.pop();
            switch (top) {
                case "]" -> {
                    if (str.charAt(i) != '[') return false;
                }
                case "}" -> {
                    if (str.charAt(i) != '{') return false;
                }
                case ")" -> {
                    if (str.charAt(i) != '(') return false;
                }
            }
        }
        return true;
    }
}
