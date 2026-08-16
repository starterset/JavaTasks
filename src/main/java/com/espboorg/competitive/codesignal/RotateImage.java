package com.espboorg.competitive.codesignal;

public class RotateImage {
    static int[][] rotate(int[][] a) {
        int[][] temp = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                temp[j][a.length - 1 - i] = a[i][j];
            }
        }
        return temp;
    }

    static int[][] rotateOptimal(int[][] a) {
        int N = a.length - 1;
        for (int i = 0; i <= N / 2; i++) {
            for (int j = i; j < N - i; j++) {
                int temp = a[i][j];
                a[i][j] = a[N - j][i];
                a[N - j][i] = a[N - i][N - j];
                a[N - i][N - j] = a[j][N - i];
                a[j][N - i] = temp;
            }
        }
        return a;
    }
}
