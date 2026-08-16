/*
You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds’ scores.
At the beginning of the game, you start with an empty record. You are given a list of strings ops , where ops[i] is the ith operation you must apply to the record
and Is one of the following:

- An integer x - Record anew score of x
- "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
- "D* - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
- "c* - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.

Return the sum of all the scores on the record.
*/
package com.espboorg.competitive.turing_com;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static void main(String[] args) {
        String[] ops1 = {"1"};
        System.out.println(calPoints(ops1));
        String[] ops2 = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops2));
        String[] ops3 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ops3));
    }

    public static int calPoints(String[] ops) {
        int result = 0;
        List<Integer> scores = new ArrayList<>(ops.length);

        for (String s : ops) {
            switch (s) {
                case "+" -> {
                    scores.add(scores.get(scores.size() - 1) + scores.get(scores.size() - 2));
                }
                case "C" -> {
                    scores.remove(scores.size() - 1);
                }
                case "D" -> {
                    scores.add(scores.get(scores.size() - 1) * 2);
                }
                default -> {
                    scores.add(Integer.parseInt(s));
                }
            }
        }

        for (int score : scores) {
            result += score;
        }
        return result;
    }
}
