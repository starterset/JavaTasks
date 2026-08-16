package com.espboorg.competitive.hackerrank._16_01_22;

/*
    [3, 6, 9, 1, 7]
    -------------------------------
    max1 = 9
    max2 = 7
    -------------------------------
    [3, 6, 9, 1, 9]
    -------------------------------
    max1 = 9
    max2 = 9
    -------------------------------
    void get2MaxNo(int array[]) {}
*/

import java.util.Arrays;

public class MaxNumbers {
    public static void main(String[] args) {
        int[] test1 = {3, 6, 9, 1, 7};
        int[] test2 = {3, 6, 9, 1, 9};
        System.out.println(Arrays.toString(get2MaxNo(test1)));
        System.out.println(Arrays.toString(get2MaxNo(test2)));
    }

    static int[] get2MaxNo(int[] array) {
        int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int el : array) {
            if (el > max[0]) {
                max[1] = max[0];
                max[0] = el;
            } else if (el > max[1]) {
                max[1] = el;
            }
        }
        return max;
    }
}
