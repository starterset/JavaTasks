package com.espboorg.competitive.codesignal;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RotateImageTest {

    @Test
    void testRotate() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] newArr = RotateImage.rotate(arr);
        assertEquals("[7, 4, 1]", Arrays.toString(newArr[0]));
        assertEquals(1, newArr[0][2]);
        assertEquals(2, newArr[1][2]);
        assertEquals(3, newArr[2][2]);
        assertEquals(4, newArr[0][1]);
        assertEquals(5, newArr[1][1]);
        assertEquals(6, newArr[2][1]);
        assertEquals(7, newArr[0][0]);
        assertEquals(8, newArr[1][0]);
        assertEquals(9, newArr[2][0]);

        int[][] arr1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] newArr1 = RotateImage.rotate(arr1);
        assertEquals("[13, 9, 5, 1]", Arrays.toString(newArr1[0]));
        assertEquals("[14, 10, 6, 2]", Arrays.toString(newArr1[1]));
        assertEquals("[15, 11, 7, 3]", Arrays.toString(newArr1[2]));
        assertEquals("[16, 12, 8, 4]", Arrays.toString(newArr1[3]));
        assertEquals("[[13, 9, 5, 1], [14, 10, 6, 2], [15, 11, 7, 3], [16, 12, 8, 4]]", Arrays.deepToString(newArr1));
    }

    @Test
    void testRotateOptimal() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] newArr = RotateImage.rotateOptimal(arr);
        assertEquals(1, newArr[0][2]);
        assertEquals(2, newArr[1][2]);
        assertEquals(3, newArr[2][2]);
        assertEquals(4, newArr[0][1]);
        assertEquals(5, newArr[1][1]);
        assertEquals(6, newArr[2][1]);
        assertEquals(7, newArr[0][0]);
        assertEquals(8, newArr[1][0]);
        assertEquals(9, newArr[2][0]);

        int[][] arr1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] newArr1 = RotateImage.rotate(arr1);
        assertEquals("[[13, 9, 5, 1], [14, 10, 6, 2], [15, 11, 7, 3], [16, 12, 8, 4]]", Arrays.deepToString(newArr1));
    }
}