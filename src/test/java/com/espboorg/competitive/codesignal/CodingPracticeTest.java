package com.espboorg.competitive.codesignal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CodingPracticeTest {
    @Test
    void testAreCoprime() {
        assertTrue(CodingPractice.areCoprime(1, 1));
        assertTrue(CodingPractice.areCoprime(8, 25));
        assertTrue(CodingPractice.areCoprime(15, 28));
        assertFalse(CodingPractice.areCoprime(12, 18));
        assertFalse(CodingPractice.areCoprime(14, 49));
        assertFalse(CodingPractice.areCoprime(22, 77));
        assertFalse(CodingPractice.areCoprime(17, 51));
        assertFalse(CodingPractice.areCoprime(35, 49));
        assertTrue(CodingPractice.areCoprime(2167, 2183));
    }

    @Test
    void testNthPrime() {
        assertEquals(2, CodingPractice.nthPrime(1));
        assertEquals(3, CodingPractice.nthPrime(2));
        assertEquals(5, CodingPractice.nthPrime(3));
        assertEquals(7, CodingPractice.nthPrime(4));
        assertEquals(11, CodingPractice.nthPrime(5));
        assertEquals(13, CodingPractice.nthPrime(6));
        assertEquals(17, CodingPractice.nthPrime(7));
    }

    @Test
    void testIndexOfFirstOccurrence() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 2, 4, 2, 7, 5, 5, 8, 4, 7, 6, 3, 9, 6);
        assertEquals(0, CodingPractice.indexOfFirstOccurrence(integerList, 1));
        assertEquals(1, CodingPractice.indexOfFirstOccurrence(integerList, 2));
        assertEquals(2, CodingPractice.indexOfFirstOccurrence(integerList, 3));
        assertEquals(4, CodingPractice.indexOfFirstOccurrence(integerList, 4));
        assertEquals(7, CodingPractice.indexOfFirstOccurrence(integerList, 5));
        assertEquals(12, CodingPractice.indexOfFirstOccurrence(integerList, 6));
        assertEquals(6, CodingPractice.indexOfFirstOccurrence(integerList, 7));
        assertEquals(9, CodingPractice.indexOfFirstOccurrence(integerList, 8));
        assertEquals(14, CodingPractice.indexOfFirstOccurrence(integerList, 9));
        assertEquals(-1, CodingPractice.indexOfFirstOccurrence(integerList, 10));
        assertEquals(-1, CodingPractice.indexOfFirstOccurrence(integerList, 63));
    }

    @Test
    void testCountUniqueElements() {
        assertEquals(3, CodingPractice.countUniqueElements(Arrays.asList(1, 2, 3, 2, 4)));
        assertEquals(6, CodingPractice.countUniqueElements(Arrays.asList(11, 32, 83, 32, 44, 58, 61, 11, 32, 44, 31, 98, 94, 98, 65)));
        assertEquals(0, CodingPractice.countUniqueElements(Arrays.asList(-1000, -1000, -1000, 1000, 1000, 1000)));
        assertEquals(0, CodingPractice.countUniqueElements(Arrays.asList(1000, 1000, 1000, 1000, 1000, -1000, -1000, -1000)));
    }

    @Test
    void testReverseList() {
        var reversed = CodingPractice.reverseList(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(5, reversed.size());
        assertEquals(5, reversed.getFirst());
        assertEquals(3, reversed.get(reversed.size() / 2));
        assertEquals(1, reversed.getLast());

        reversed = CodingPractice.reverseList(Arrays.asList(100, 25, 43, 20, 91, 101, 235, 364));
        assertEquals(8, reversed.size());
        assertEquals(364, reversed.getFirst());
        assertEquals(20, reversed.get(reversed.size() / 2));
        assertEquals(100, reversed.getLast());
    }

    @Test
    void shiftListElements() {
        var shiftedList = CodingPractice.shiftListElements(Arrays.asList(1, 2, 3, 4, 5), 2);
        assertEquals(5, shiftedList.size());
        assertEquals(4, shiftedList.getFirst());
        assertEquals(1, shiftedList.get(shiftedList.size() / 2));
        assertEquals(3, shiftedList.getLast());

        shiftedList = CodingPractice.shiftListElements(Arrays.asList(1, 2, 3, 4, 5), -1);
        assertEquals(5, shiftedList.size());
        assertEquals(2, shiftedList.getFirst());
        assertEquals(4, shiftedList.get(shiftedList.size() / 2));
        assertEquals(1, shiftedList.getLast());

        shiftedList = CodingPractice.shiftListElements(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), -8);
        assertEquals(8, shiftedList.size());
        assertEquals(1, shiftedList.getFirst());
        assertEquals(5, shiftedList.get(shiftedList.size() / 2));
        assertEquals(8, shiftedList.getLast());

        shiftedList = CodingPractice.shiftListElements(Arrays.asList(-1000, -999, -998, -997, -996), -1000);
        assertEquals(5, shiftedList.size());
        assertEquals(-1000, shiftedList.getFirst());
        assertEquals(-998, shiftedList.get(shiftedList.size() / 2));
        assertEquals(-996, shiftedList.getLast());

        shiftedList = CodingPractice.shiftListElements(Arrays.asList(1, 5, 10, 15, 20), 100);
        assertEquals(5, shiftedList.size());
        assertEquals(1, shiftedList.getFirst());
        assertEquals(10, shiftedList.get(shiftedList.size() / 2));
        assertEquals(20, shiftedList.getLast());

        shiftedList = CodingPractice.shiftListElements(Arrays.asList(1, 2, 3), -4);
        assertEquals(3, shiftedList.size());
        assertEquals(2, shiftedList.getFirst());
        assertEquals(3, shiftedList.get(shiftedList.size() / 2));
        assertEquals(1, shiftedList.getLast());
    }

    @Test
    void testContiguousSubarray1() {
        int[] listA = {1, 2, 2, 3, 2, 4, 5};
        int[] listB = {2, 3, 3};
        assertFalse(CodingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray2() {
        int[] listA = {-1, -2, -3, -4, -5};
        int[] listB = {-3, -2, -4};
        assertFalse(CodingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray3() {
        int[] listA = {1, 2, 3, 4, 5};
        int[] listB = {2, 3, 4};
        assertTrue(CodingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray4() {
        int[] listA = {1, -1, 3, -2, 3, 2, 5};
        int[] listB = {3, 2};
        assertTrue(CodingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray5() {
        int[] listA = {1, 2, 2, 3, 2, 4, 5};
        int[] listB = {2, 2, 3};
        assertTrue(CodingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray6() {
        int[] listA = {-5, 9, -5};
        int[] listB = {-5};
        assertTrue(CodingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray7() {
        int[] listA = {1, 2, 3, 4, 5};
        int[] listB = {3, 4, 6};
        assertFalse(CodingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray8() {
        int[] listA = {5, 4, 3, 2, 1};
        int[] listB = {1, 3, 2};
        assertFalse(CodingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray9() {
        int[] listA = {-5, 9, -5};
        int[] listB = {5};
        assertFalse(CodingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testGenerateListFromNTo1_1() {
        List<Integer> generatedListFromNTo1 = CodingPractice.generateListFromNTo1(5);
        assertEquals(5, generatedListFromNTo1.size());
        assertEquals(5, generatedListFromNTo1.getFirst());
        assertEquals(1, generatedListFromNTo1.getLast());
    }

    @Test
    void testGenerateListFromNTo1_2() {
        List<Integer> generatedListFromNTo1 = CodingPractice.generateListFromNTo1(20);
        assertEquals(20, generatedListFromNTo1.size());
        assertEquals(20, generatedListFromNTo1.getFirst());
        assertEquals(1, generatedListFromNTo1.getLast());
    }

    @Test
    void testSumOfDigitsRaisedToPositions() {
        assertEquals(36, CodingPractice.sumOfDigitsRaisedToPositions(253));
        assertEquals(78, CodingPractice.sumOfDigitsRaisedToPositions(1429));
        assertEquals(2437, CodingPractice.sumOfDigitsRaisedToPositions(7253));
    }

    @Test
    void testReverseString() {
        assertEquals("olleh", CodingPractice.reverseString("hello"));
    }

    @Test
    void testFibonacci() {
        assertEquals(2, CodingPractice.fibonacci(3));
        assertEquals(55, CodingPractice.fibonacci(10));
    }

    @Test
    void testIsToeplitzMatrix_1() {
        int[][] matrix = {
                {1, 4, 3},
                {5, 1, 4},
                {8, 5, 1}
        };
        assertTrue(CodingPractice.isToeplitzMatrix(matrix));
    }

    @Test
    void testIsToeplitzMatrix_2() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertFalse(CodingPractice.isToeplitzMatrix(matrix));
    }

    @Test
    void testIsToeplitzMatrix_3() {
        int[][] matrix = {
                {1, 4, 3, 6},
                {5, 1, 4, 3},
                {8, 5, 1, 4},
                {7, 8, 5, 1}
        };
        assertTrue(CodingPractice.isToeplitzMatrix(matrix));
    }

    @Test
    void testCountLessThan_1() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7}
        };
        assertEquals(10, CodingPractice.countLessThan(matrix, 5));
    }

    @Test
    void testCountLessThan_2() {
        int[][] matrix = {
                {1, 2, 4, 8, 16},
                {2, 4, 8, 16, 32},
                {4, 8, 16, 32, 64},
                {8, 16, 32, 64, 128},
                {16, 32, 64, 128, 256}
        };
        assertEquals(22, CodingPractice.countLessThan(matrix, 100));
    }

    @Test
    void testCountLessThan_3() {
        int[][] matrix = {
                {-10, -5, 0, 5},
                {0, 5, 10, 15},
                {10, 15, 20, 25},
                {20, 25, 30, 35}
        };
        assertEquals(4, CodingPractice.countLessThan(matrix, 5));
    }

    @Test
    void testCountLessThan_4() {
        int[][] matrix = {
                {1000000, 1000000},
                {1000000, 1000000}
        };
        assertEquals(0, CodingPractice.countLessThan(matrix, 1000000));
    }

    @Test
    void testCountLessThan_5() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7}
        };
        assertEquals(3, CodingPractice.countLessThan(matrix, 3));
    }

    @Test
    void testMinMaxInSecondaryDiagonal() {
        int[][] grid = {
                {9, 2, 3, 4},
                {2, 3, 1, 5},
                {3, 8, 5, 6},
                {9, 5, 6, 7}
        };
        List<Integer> minMax = CodingPractice.minMaxInSecondaryDiagonal(grid);
        assertEquals(1, minMax.getFirst());
        assertEquals(9, minMax.getLast());
    }

    @Test
    void testFindRowWithTarget_1() {
        int[][] grid = {
                {1, 4, 7},
                {14, 15, 16},
                {22, 23, 24}
        };
        assertNull(CodingPractice.findRowWithTarget(grid, 25));
    }

    @Test
    void testFindRowWithTarget_2() {
        int[][] grid = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        assertEquals(2, CodingPractice.findRowWithTarget(grid, 9));
    }

    @Test
    void testReverseArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] reversedArray = CodingPractice.reverseArray(array);
        assertEquals(9, reversedArray[0]);
        assertEquals(8, reversedArray[1]);
        assertEquals(2, reversedArray[7]);
        assertEquals(1, reversedArray[8]);
    }

    @Test
    void testAntiRotateArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        CodingPractice.antiRotateArray(array, 3);
        assertEquals(4, array[0]);
        assertEquals(5, array[1]);
        assertEquals(6, array[2]);
        assertEquals(7, array[3]);
        assertEquals(1, array[4]);
        assertEquals(2, array[5]);
        assertEquals(3, array[6]);
    }

    @Test
    void testShuffleArray_1() {
        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> shuffledArray = CodingPractice.shuffleArray(integerList, 3);
        assertEquals(1, shuffledArray.getFirst());
        assertEquals(2, shuffledArray.get(1));
        assertEquals(4, shuffledArray.get(2));
        assertEquals(5, shuffledArray.get(3));
        assertEquals(7, shuffledArray.get(4));
        assertEquals(8, shuffledArray.get(5));
        assertEquals(3, shuffledArray.get(6));
        assertEquals(6, shuffledArray.getLast());
    }

    @Test
    void testShuffleArray_2() {
        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> shuffledArray = CodingPractice.shuffleArray(integerList, 1);
        assertEquals(1, shuffledArray.getFirst());
        assertEquals(2, shuffledArray.get(1));
        assertEquals(3, shuffledArray.get(2));
        assertEquals(4, shuffledArray.get(3));
        assertEquals(5, shuffledArray.get(4));
        assertEquals(6, shuffledArray.get(5));
        assertEquals(7, shuffledArray.get(6));
        assertEquals(8, shuffledArray.getLast());
    }

    @Test
    void testShuffleArray_3() {
        List<Integer> integerList = new ArrayList<>(List.of(766, 243, -12, 24, 0, 41));
        List<Integer> shuffledArray = CodingPractice.shuffleArray(integerList, 2);
        assertEquals(766, shuffledArray.getFirst());
        assertEquals(-12, shuffledArray.get(1));
        assertEquals(0, shuffledArray.get(2));
        assertEquals(243, shuffledArray.get(3));
        assertEquals(24, shuffledArray.get(4));
        assertEquals(41, shuffledArray.getLast());
    }

    @Test
    void testShuffleArray_4() {
        List<Integer> integerList = new ArrayList<>(List.of(100, 200, 300, 400, 500, 600, 700, 800, 900));
        List<Integer> shuffledArray = CodingPractice.shuffleArray(integerList, 9);
        assertEquals(100, shuffledArray.getFirst());
        assertEquals(200, shuffledArray.get(1));
        assertEquals(300, shuffledArray.get(2));
        assertEquals(400, shuffledArray.get(3));
        assertEquals(500, shuffledArray.get(4));
        assertEquals(600, shuffledArray.get(5));
        assertEquals(700, shuffledArray.get(6));
        assertEquals(800, shuffledArray.get(7));
        assertEquals(900, shuffledArray.getLast());
    }

    @Test
    void testReverseArrayInChunks_1() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] reversed = CodingPractice.reverseArrayInGroups(array, 3);
        assertEquals(3, reversed[0]);
        assertEquals(2, reversed[1]);
        assertEquals(1, reversed[2]);
        assertEquals(6, reversed[3]);
        assertEquals(5, reversed[4]);
        assertEquals(4, reversed[5]);
        assertEquals(9, reversed[6]);
        assertEquals(8, reversed[7]);
        assertEquals(7, reversed[8]);
    }

    @Test
    void testReverseArrayInChunks_2() {
        int[] array = new int[]{2, 3};
        int[] reversed = CodingPractice.reverseArrayInGroups(array, 2);
        assertEquals(3, reversed[0]);
        assertEquals(2, reversed[1]);
    }

    @Test
    void testReverseArrayInChunks_3() {
        int[] array = new int[]{10, 20, 30, 40, 50, 60, 70};
        int[] reversed = CodingPractice.reverseArrayInGroups(array, 5);
        assertEquals(50, reversed[0]);
        assertEquals(40, reversed[1]);
        assertEquals(30, reversed[2]);
        assertEquals(20, reversed[3]);
        assertEquals(10, reversed[4]);
        assertEquals(70, reversed[5]);
        assertEquals(60, reversed[6]);
    }

    @Test
    @DisplayName("Example Test Case: n = 8 (Divisible by 4)")
    void testRearrangeArray_StandardDivisibleByFour() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {3, 4, 5, 6, 1, 2, 7, 8};

        CodingPractice.rearrangeArray(input);

        assertArrayEquals(expected, input, "Array should match [Q2, Q3, Q1, Q4]");
    }

    @Test
    @DisplayName("Minimum Divisible Length: n = 4")
    void testMinimumDivisibleLength() {
        int[] input = {10, 20, 30, 40};
        int[] expected = {20, 30, 10, 40};

        CodingPractice.rearrangeArray(input);

        assertArrayEquals(expected, input);
    }

    @ParameterizedTest(name = "Non-divisible length n = {0}")
    @MethodSource("provideNonDivisibleCases")
    @DisplayName("Test Array Lengths Not Divisible By 4")
    void testNonDivisibleLengths(int n, int[] input, int[] expected) {
        CodingPractice.rearrangeArray(input);
        assertArrayEquals(expected, input);
    }

    private static Stream<Arguments> provideNonDivisibleCases() {
        return Stream.of(
                // n = 5 (remainder 1): Q1 = 1, Q4 = 1, Middle = 3
                Arguments.of(5, new int[]{1, 2, 3, 4, 5}, new int[]{2, 3, 4, 1, 5}),

                // n = 6 (remainder 2): Q1 = 1, Q4 = 1, Middle = 4
                Arguments.of(6, new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 4, 5, 1, 6}),

                // n = 7 (remainder 3): Q1 = 1, Q4 = 1, Middle = 5
                Arguments.of(7, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{2, 3, 4, 5, 6, 1, 7}),

                // n = 9 (remainder 1): Q1 = 2, Q4 = 2, Middle = 5
                Arguments.of(9, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{3, 4, 5, 6, 7, 1, 2, 8, 9})
        );
    }

    @Test
    @DisplayName("Boundary Case: Lengths Less Than 4 Should Remain Unchanged")
    void testBoundaryCasesLessThanFour() {
        // n = 0
        int[] empty = {};
        CodingPractice.rearrangeArray(empty);
        assertArrayEquals(new int[]{}, empty);

        // n = 1
        int[] single = {42};
        CodingPractice.rearrangeArray(single);
        assertArrayEquals(new int[]{42}, single);

        // n = 2
        int[] pair = {1, 2};
        CodingPractice.rearrangeArray(pair);
        assertArrayEquals(new int[]{1, 2}, pair);

        // n = 3
        int[] trio = {1, 2, 3};
        CodingPractice.rearrangeArray(trio);
        assertArrayEquals(new int[]{1, 2, 3}, trio);
    }

    @Test
    @DisplayName("Handling Negative and Duplicate Numbers")
    void testNegativeAndDuplicateNumbers() {
        int[] input = {-5, 0, -5, 10, 20, 30, -5, 100};
        int[] expected = {-5, 10, 20, 30, -5, 0, -5, 100};

        CodingPractice.rearrangeArray(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testCommonCharsInOrder() {
        assertEquals("abcd", CodingPractice.commonCharsInOrder("abcd", "dcba"));
        assertEquals("ape", CodingPractice.commonCharsInOrder("apple", "peach"));
        assertEquals("abc", CodingPractice.commonCharsInOrder("aabbcc", "abc"));
        assertEquals("aaaa", CodingPractice.commonCharsInOrder("aaaa", "aaaa"));
        assertEquals("abcdef", CodingPractice.commonCharsInOrder("abcdef", "fedcba"));
        assertEquals("abcd", CodingPractice.commonCharsInOrder("aabbccdd", "bcda"));
        assertEquals("python", CodingPractice.commonCharsInOrder("python", "thonpy"));
        assertEquals("iervew", CodingPractice.commonCharsInOrder("interview", "review"));
        assertEquals("", CodingPractice.commonCharsInOrder("aaaaa", "b"));
        assertEquals("", CodingPractice.commonCharsInOrder("abc", "def"));
    }

    @Test
    public void testLongestCommonSuffix() {
        assertEquals("arking", CodingPractice.longestCommonSuffix(new String[]{"barking", "parking", "starking"}));
        assertEquals("ower", CodingPractice.longestCommonSuffix(new String[]{"flower", "tower", "power"}));
        assertEquals("a", CodingPractice.longestCommonSuffix(new String[]{"alpha", "beta", "gamma"}));
        assertEquals("acer", CodingPractice.longestCommonSuffix(new String[]{"racer", "placer", "effacer"}));
        assertEquals("ello", CodingPractice.longestCommonSuffix(new String[]{"hello", "jello"}));
        assertEquals("word", CodingPractice.longestCommonSuffix(new String[]{"word"}));
        assertEquals("apple", CodingPractice.longestCommonSuffix(new String[]{"apple", "grapple", "pineapple"}));
        assertEquals("a", CodingPractice.longestCommonSuffix(new String[]{"a", "aa", "aaa"}));
        assertEquals("", CodingPractice.longestCommonSuffix(new String[]{"ab", "abc", "abcd"}));
        assertEquals("", CodingPractice.longestCommonSuffix(new String[]{}));
        assertEquals("duction", CodingPractice.longestCommonSuffix(new String[]{"introduction", "reduction", "production", "seduction"}));
        assertEquals("ation", CodingPractice.longestCommonSuffix(new String[]{"communication", "station", "vacation", "nation"}));
        assertEquals("oon", CodingPractice.longestCommonSuffix(new String[]{"spoon", "moon", "balloon", "cartoon", "raccoon"}));
        assertEquals("dabra", CodingPractice.longestCommonSuffix(new String[]{"abracadabra", "dabra", "califragilisticexpialidociousdabra"}));
        assertEquals("mation", CodingPractice.longestCommonSuffix(new String[]{"transformation", "information", "formation", "automation"}));
        assertEquals("eater", CodingPractice.longestCommonSuffix(new String[]{"repeater", "defeater", "heater", "seater", "eater"}));
        assertEquals("ility", CodingPractice.longestCommonSuffix(new String[]{"intelligibility", "responsibility", "agility", "ability"}));
        assertEquals("ization", CodingPractice.longestCommonSuffix(new String[]{"synchronization", "organization", "localization", "realization"}));
        assertEquals("plication", CodingPractice.longestCommonSuffix(new String[]{"complication", "application", "implication", "replication", "duplication"}));
        assertEquals("anding", CodingPractice.longestCommonSuffix(new String[]{"understanding", "withstanding", "demanding", "commanding", "handing"}));
    }

    @Test
    public void testRepeatSubstring() {
        assertEquals("ab", CodingPractice.repeatSubstring("ababab"));
        assertEquals("", CodingPractice.repeatSubstring("abcab"));
        assertEquals("", CodingPractice.repeatSubstring("abcab"));
        assertEquals("", CodingPractice.repeatSubstring("abcabcab"));
        assertEquals("", CodingPractice.repeatSubstring("abcabcabd"));
        assertEquals("zz", CodingPractice.repeatSubstring("zzzz"));
        assertEquals("", CodingPractice.repeatSubstring("#$#$$$#$#"));
        assertEquals("Python", CodingPractice.repeatSubstring("PythonPythonPython"));
        assertEquals("", CodingPractice.repeatSubstring("0"));
        assertEquals("", CodingPractice.repeatSubstring("10011001100110011"));
        assertEquals("qwerty", CodingPractice.repeatSubstring("qwertyqwertyqwerty"));
        assertEquals("aaaaa", CodingPractice.repeatSubstring("aaaaaaaaaa"));
        assertEquals("", CodingPractice.repeatSubstring("abababcbcbcbc"));
        assertEquals("abab", CodingPractice.repeatSubstring("abababab"));
        assertEquals("11111", CodingPractice.repeatSubstring("1111111111"));
        assertEquals("xyzxyzxyz", CodingPractice.repeatSubstring("xyzxyzxyzxyzxyzxyz"));
        assertEquals("a".repeat(5000), CodingPractice.repeatSubstring("a".repeat(10000)));
        assertEquals("bmbmbmbmbmbmbmbmbmbmb", CodingPractice.repeatSubstring("bmbmbmbmbmbmbmbmbmbmbbmbmbmbmbmbmbmbmbmbmb"));
        assertEquals("lololo", CodingPractice.repeatSubstring("lololololololololo"));
        assertEquals("abcdefghij", CodingPractice.repeatSubstring("abcdefghijabcdefghijabcdefghij"));
        assertEquals("", CodingPractice.repeatSubstring("y".repeat(999) + "z"));
        assertEquals("tut", CodingPractice.repeatSubstring("tuttuttuttuttut"));
    }

    @Test
    public void testEfficient_LCP() {
        assertEquals("fl", CodingPractice.efficient_LCP(new String[]{"floss", "flight", "floral"}));
        assertEquals("acorns", CodingPractice.efficient_LCP(new String[]{"acorns", "acornsa", "acornsac", "acornsab"}));
        assertEquals("abcd", CodingPractice.efficient_LCP(new String[]{"abcd", "abcd", "abcd", "abcd"}));
        assertEquals("a", CodingPractice.efficient_LCP(new String[]{"abc", "a", "abcd"}));
        assertEquals("abcd", CodingPractice.efficient_LCP(new String[]{"abcde", "abcdf"}));
        assertEquals("", CodingPractice.efficient_LCP(new String[]{"tree", "treat", "break"}));
        assertEquals("", CodingPractice.efficient_LCP(new String[]{"abcd", "efgh", "ijkl"}));
        assertEquals("appl", CodingPractice.efficient_LCP(new String[]{"apple", "applied", "apply"}));
        assertEquals("appl", CodingPractice.efficient_LCP(new String[]{"apply", "applan", "applet"}));
        assertEquals("", CodingPractice.efficient_LCP(new String[]{"python", "java", "javascript"}));
        assertEquals("anim", CodingPractice.efficient_LCP(new String[]{"animal", "animosity", "animate"}));
        assertEquals("so", CodingPractice.efficient_LCP(new String[]{"song", "soprano", "sonar"}));
        assertEquals("cru", CodingPractice.efficient_LCP(new String[]{"crumble", "crunched", "crust"}));
        assertEquals("", CodingPractice.efficient_LCP(new String[]{"spring", "summer", "fall"}));
        assertEquals("", CodingPractice.efficient_LCP(new String[]{"", "abcd", "wxyz"}));
        assertEquals("r", CodingPractice.efficient_LCP(new String[]{"rotate", "rated", "rater"}));
        assertEquals("tas", CodingPractice.efficient_LCP(new String[]{"tasmania", "task", "tassel"}));
        assertEquals("rock", CodingPractice.efficient_LCP(new String[]{"rock", "rocket", "rocky"}));
        assertEquals("inv", CodingPractice.efficient_LCP(new String[]{"invitation", "invigorating", "invalid"}));
        assertEquals("inter", CodingPractice.efficient_LCP(new String[]{"intermingle", "intercept", "interchange"}));
    }

    @Test
    public void testFindMostCommonSubstring() {
        assertEquals("anaba", CodingPractice.findMostCommonSubstring("bananabananaba", 5));
        assertEquals(".aa", CodingPractice.findMostCommonSubstring("a.b.aa.ab.", 3));
        assertEquals("ab", CodingPractice.findMostCommonSubstring("abcabcabc", 2));
        assertEquals("r", CodingPractice.findMostCommonSubstring("zyxwvutsr", 1));
        assertEquals("demiol", CodingPractice.findMostCommonSubstring("epidemiology", 6));
        assertEquals("abcd", CodingPractice.findMostCommonSubstring("abcdabcdabcdabcdabcd", 4));
        assertEquals("lol", CodingPractice.findMostCommonSubstring("lololololo", 3));
        assertEquals("a", CodingPractice.findMostCommonSubstring("a", 1));
        assertEquals("a", CodingPractice.findMostCommonSubstring("aa", 1));
        assertEquals("a", CodingPractice.findMostCommonSubstring("abcdefgh", 1));
        assertEquals("abcdefgh", CodingPractice.findMostCommonSubstring("abcdefgh", 8));
        assertEquals("xy", CodingPractice.findMostCommonSubstring("xyzzyx", 2));
        assertEquals("abcd", CodingPractice.findMostCommonSubstring("abcd", 4));
        assertEquals("a", CodingPractice.findMostCommonSubstring("aaa", 1));
        assertEquals("ace", CodingPractice.findMostCommonSubstring("racecar", 3));
        assertEquals("aaa", CodingPractice.findMostCommonSubstring("aaabbb", 3));
    }

    @Test
    public void testMergeSortedLists_1() {
        List<Integer> l1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> l2 = Arrays.asList(2, 2, 3, 4, 6, 6);
        List<Integer> expected = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 9);
        assertEquals(expected, CodingPractice.mergeSortedLists(l1, l2));
    }

    @Test
    public void testMergeSortedLists_2() {
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(1, 2, 3);
        List<Integer> expected = Arrays.asList(1, 1, 2, 2, 3, 3);
        assertEquals(expected, CodingPractice.mergeSortedLists(l1, l2));
    }

    @Test
    public void testMergeSortedListsDescendingUnique() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(2, 3, 5, 6, 10);
        List<Integer> expected = Arrays.asList(10, 6, 5, 4, 3, 2, 1);
        assertEquals(expected, CodingPractice.mergeSortedListsDescendingUnique(list1, list2));
    }

    @Test
    public void testRemoveCommonElements_1() {
        List<Integer> res = CodingPractice.removeCommonElements(Arrays.asList(2, 5, 7, 10), Arrays.asList(1, 5, 9));
        assertEquals(Arrays.asList(1, 2, 7, 9, 10), res);
    }

    @Test
    public void testRemoveCommonElements_2() {
        List<Integer> res = CodingPractice.removeCommonElements(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4));
        assertEquals(Arrays.asList(1, 4), res);
    }

    @Test
    public void testMergeNSortedLists_1() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 5, 9),
                Arrays.asList(2, 3, 10),
                Arrays.asList(4, 6, 8)
        );
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 9, 10);
        assertEquals(expected, CodingPractice.mergeNSortedLists(input));
    }

    @Test
    public void testMergeNSortedLists_2() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(111, 125, 143, 145),
                Arrays.asList(39, 128, 150, 160),
                Arrays.asList(58, 130, 166, 198)
        );
        List<Integer> expected = Arrays.asList(39, 58, 111, 125, 128, 130, 143, 145, 150, 160, 166, 198);
        assertEquals(expected, CodingPractice.mergeNSortedLists(input));
    }

    @Test
    public void testSelectionSort() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 7, 9}, CodingPractice.selectionSort(new int[]{1, 7, 5, 2, 3, 9, 4}));
    }

    @Test
    public void testInsertionSort() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, CodingPractice.insertionSort(new int[]{5, 2, 4, 6, 1, 3}));
    }

    @Test
    public void testMergeSort() {
        int[] input = {10, 3, 2, 8, -1, 5, 1};
        int[] output = {-1, 1, 2, 3, 5, 8, 10};
        assertArrayEquals(CodingPractice.mergeSort(input), output);
    }

    @Test
    public void testQuickSortCustom() {
        List<Integer> input = Arrays.asList(6, 5, 3, 1, 8, 7, 2, 4);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(expected, CodingPractice.quickSortCustom(input));
    }
}
