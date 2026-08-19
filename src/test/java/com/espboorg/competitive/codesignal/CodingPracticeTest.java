package com.espboorg.competitive.codesignal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    CodingPractice codingPractice;

    @BeforeEach
    void setUp() {
        codingPractice = new CodingPractice();
    }

    @AfterEach
    void tearDown() {
        codingPractice = null;
    }

    @Test
    void testAreCoprime() {
        assertTrue(codingPractice.areCoprime(1, 1));
        assertTrue(codingPractice.areCoprime(8, 25));
        assertTrue(codingPractice.areCoprime(15, 28));
        assertFalse(codingPractice.areCoprime(12, 18));
        assertFalse(codingPractice.areCoprime(14, 49));
        assertFalse(codingPractice.areCoprime(22, 77));
        assertFalse(codingPractice.areCoprime(17, 51));
        assertFalse(codingPractice.areCoprime(35, 49));
        assertTrue(codingPractice.areCoprime(2167, 2183));
    }

    @Test
    void testNthPrime() {
        assertEquals(2, codingPractice.nthPrime(1));
        assertEquals(3, codingPractice.nthPrime(2));
        assertEquals(5, codingPractice.nthPrime(3));
        assertEquals(7, codingPractice.nthPrime(4));
        assertEquals(11, codingPractice.nthPrime(5));
        assertEquals(13, codingPractice.nthPrime(6));
        assertEquals(17, codingPractice.nthPrime(7));
    }

    @Test
    void testIndexOfFirstOccurrence() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 2, 4, 2, 7, 5, 5, 8, 4, 7, 6, 3, 9, 6);
        assertEquals(0, codingPractice.indexOfFirstOccurrence(integerList, 1));
        assertEquals(1, codingPractice.indexOfFirstOccurrence(integerList, 2));
        assertEquals(2, codingPractice.indexOfFirstOccurrence(integerList, 3));
        assertEquals(4, codingPractice.indexOfFirstOccurrence(integerList, 4));
        assertEquals(7, codingPractice.indexOfFirstOccurrence(integerList, 5));
        assertEquals(12, codingPractice.indexOfFirstOccurrence(integerList, 6));
        assertEquals(6, codingPractice.indexOfFirstOccurrence(integerList, 7));
        assertEquals(9, codingPractice.indexOfFirstOccurrence(integerList, 8));
        assertEquals(14, codingPractice.indexOfFirstOccurrence(integerList, 9));
        assertEquals(-1, codingPractice.indexOfFirstOccurrence(integerList, 10));
        assertEquals(-1, codingPractice.indexOfFirstOccurrence(integerList, 63));
    }

    @Test
    void testCountUniqueElements() {
        assertEquals(3, codingPractice.countUniqueElements(Arrays.asList(1, 2, 3, 2, 4)));
        assertEquals(6, codingPractice.countUniqueElements(Arrays.asList(11, 32, 83, 32, 44, 58, 61, 11, 32, 44, 31, 98, 94, 98, 65)));
        assertEquals(0, codingPractice.countUniqueElements(Arrays.asList(-1000, -1000, -1000, 1000, 1000, 1000)));
        assertEquals(0, codingPractice.countUniqueElements(Arrays.asList(1000, 1000, 1000, 1000, 1000, -1000, -1000, -1000)));
    }

    @Test
    void testReverseList() {
        var reversed = codingPractice.reverseList(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(5, reversed.size());
        assertEquals(5, reversed.getFirst());
        assertEquals(3, reversed.get(reversed.size() / 2));
        assertEquals(1, reversed.getLast());

        reversed = codingPractice.reverseList(Arrays.asList(100, 25, 43, 20, 91, 101, 235, 364));
        assertEquals(8, reversed.size());
        assertEquals(364, reversed.getFirst());
        assertEquals(20, reversed.get(reversed.size() / 2));
        assertEquals(100, reversed.getLast());
    }

    @Test
    void shiftListElements() {
        var shiftedList = codingPractice.shiftListElements(Arrays.asList(1, 2, 3, 4, 5), 2);
        assertEquals(5, shiftedList.size());
        assertEquals(4, shiftedList.getFirst());
        assertEquals(1, shiftedList.get(shiftedList.size() / 2));
        assertEquals(3, shiftedList.getLast());

        shiftedList = codingPractice.shiftListElements(Arrays.asList(1, 2, 3, 4, 5), -1);
        assertEquals(5, shiftedList.size());
        assertEquals(2, shiftedList.getFirst());
        assertEquals(4, shiftedList.get(shiftedList.size() / 2));
        assertEquals(1, shiftedList.getLast());

        shiftedList = codingPractice.shiftListElements(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), -8);
        assertEquals(8, shiftedList.size());
        assertEquals(1, shiftedList.getFirst());
        assertEquals(5, shiftedList.get(shiftedList.size() / 2));
        assertEquals(8, shiftedList.getLast());

        shiftedList = codingPractice.shiftListElements(Arrays.asList(-1000, -999, -998, -997, -996), -1000);
        assertEquals(5, shiftedList.size());
        assertEquals(-1000, shiftedList.getFirst());
        assertEquals(-998, shiftedList.get(shiftedList.size() / 2));
        assertEquals(-996, shiftedList.getLast());

        shiftedList = codingPractice.shiftListElements(Arrays.asList(1, 5, 10, 15, 20), 100);
        assertEquals(5, shiftedList.size());
        assertEquals(1, shiftedList.getFirst());
        assertEquals(10, shiftedList.get(shiftedList.size() / 2));
        assertEquals(20, shiftedList.getLast());

        shiftedList = codingPractice.shiftListElements(Arrays.asList(1, 2, 3), -4);
        assertEquals(3, shiftedList.size());
        assertEquals(2, shiftedList.getFirst());
        assertEquals(3, shiftedList.get(shiftedList.size() / 2));
        assertEquals(1, shiftedList.getLast());
    }

    @Test
    void testContiguousSubarray1() {
        int[] listA = {1, 2, 2, 3, 2, 4, 5};
        int[] listB = {2, 3, 3};
        assertFalse(codingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray2() {
        int[] listA = {-1, -2, -3, -4, -5};
        int[] listB = {-3, -2, -4};
        assertFalse(codingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray3() {
        int[] listA = {1, 2, 3, 4, 5};
        int[] listB = {2, 3, 4};
        assertTrue(codingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray4() {
        int[] listA = {1, -1, 3, -2, 3, 2, 5};
        int[] listB = {3, 2};
        assertTrue(codingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray5() {
        int[] listA = {1, 2, 2, 3, 2, 4, 5};
        int[] listB = {2, 2, 3};
        assertTrue(codingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray6() {
        int[] listA = {-5, 9, -5};
        int[] listB = {-5};
        assertTrue(codingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray7() {
        int[] listA = {1, 2, 3, 4, 5};
        int[] listB = {3, 4, 6};
        assertFalse(codingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray8() {
        int[] listA = {5, 4, 3, 2, 1};
        int[] listB = {1, 3, 2};
        assertFalse(codingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testContiguousSubarray9() {
        int[] listA = {-5, 9, -5};
        int[] listB = {5};
        assertFalse(codingPractice.contiguousSubarray(listA, listB));
    }

    @Test
    void testGenerateListFromNTo1_1() {
        List<Integer> generatedListFromNTo1 = codingPractice.generateListFromNTo1(5);
        assertEquals(5, generatedListFromNTo1.size());
        assertEquals(5, generatedListFromNTo1.getFirst());
        assertEquals(1, generatedListFromNTo1.getLast());
    }

    @Test
    void testGenerateListFromNTo1_2() {
        List<Integer> generatedListFromNTo1 = codingPractice.generateListFromNTo1(20);
        assertEquals(20, generatedListFromNTo1.size());
        assertEquals(20, generatedListFromNTo1.getFirst());
        assertEquals(1, generatedListFromNTo1.getLast());
    }

    @Test
    void testSumOfDigitsRaisedToPositions() {
        assertEquals(36, codingPractice.sumOfDigitsRaisedToPositions(253));
        assertEquals(78, codingPractice.sumOfDigitsRaisedToPositions(1429));
        assertEquals(2437, codingPractice.sumOfDigitsRaisedToPositions(7253));
    }

    @Test
    void testReverseString() {
        assertEquals("olleh", codingPractice.reverseString("hello"));
    }

    @Test
    void testFibonacci() {
        assertEquals(2, codingPractice.fibonacci(3));
        assertEquals(55, codingPractice.fibonacci(10));
    }

    @Test
    void testIsToeplitzMatrix_1() {
        int[][] matrix = {
                {1, 4, 3},
                {5, 1, 4},
                {8, 5, 1}
        };
        assertTrue(codingPractice.isToeplitzMatrix(matrix));
    }

    @Test
    void testIsToeplitzMatrix_2() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertFalse(codingPractice.isToeplitzMatrix(matrix));
    }

    @Test
    void testIsToeplitzMatrix_3() {
        int[][] matrix = {
                {1, 4, 3, 6},
                {5, 1, 4, 3},
                {8, 5, 1, 4},
                {7, 8, 5, 1}
        };
        assertTrue(codingPractice.isToeplitzMatrix(matrix));
    }

    @Test
    void testCountLessThan_1() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7}
        };
        assertEquals(10, codingPractice.countLessThan(matrix, 5));
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
        assertEquals(22, codingPractice.countLessThan(matrix, 100));
    }

    @Test
    void testCountLessThan_3() {
        int[][] matrix = {
                {-10, -5, 0, 5},
                {0, 5, 10, 15},
                {10, 15, 20, 25},
                {20, 25, 30, 35}
        };
        assertEquals(4, codingPractice.countLessThan(matrix, 5));
    }

    @Test
    void testCountLessThan_4() {
        int[][] matrix = {
                {1000000, 1000000},
                {1000000, 1000000}
        };
        assertEquals(0, codingPractice.countLessThan(matrix, 1000000));
    }

    @Test
    void testCountLessThan_5() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7}
        };
        assertEquals(3, codingPractice.countLessThan(matrix, 3));
    }

    @Test
    void testMinMaxInSecondaryDiagonal() {
        int[][] grid = {
                {9, 2, 3, 4},
                {2, 3, 1, 5},
                {3, 8, 5, 6},
                {9, 5, 6, 7}
        };
        List<Integer> minMax = codingPractice.minMaxInSecondaryDiagonal(grid);
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
        assertNull(codingPractice.findRowWithTarget(grid, 25));
    }

    @Test
    void testFindRowWithTarget_2() {
        int[][] grid = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        assertEquals(2, codingPractice.findRowWithTarget(grid, 9));
    }

    @Test
    void testReverseArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] reversedArray = codingPractice.reverseArray(array);
        assertEquals(9, reversedArray[0]);
        assertEquals(8, reversedArray[1]);
        assertEquals(2, reversedArray[7]);
        assertEquals(1, reversedArray[8]);
    }

    @Test
    void testAntiRotateArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        codingPractice.antiRotateArray(array, 3);
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
        List<Integer> shuffledArray = codingPractice.shuffleArray(integerList, 3);
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
        List<Integer> shuffledArray = codingPractice.shuffleArray(integerList, 1);
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
        List<Integer> shuffledArray = codingPractice.shuffleArray(integerList, 2);
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
        List<Integer> shuffledArray = codingPractice.shuffleArray(integerList, 9);
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
        int[] reversed = codingPractice.reverseArrayInGroups(array, 3);
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
        int[] reversed = codingPractice.reverseArrayInGroups(array, 2);
        assertEquals(3, reversed[0]);
        assertEquals(2, reversed[1]);
    }

    @Test
    void testReverseArrayInChunks_3() {
        int[] array = new int[]{10, 20, 30, 40, 50, 60, 70};
        int[] reversed = codingPractice.reverseArrayInGroups(array, 5);
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

        codingPractice.rearrangeArray(input);

        assertArrayEquals(expected, input, "Array should match [Q2, Q3, Q1, Q4]");
    }

    @Test
    @DisplayName("Minimum Divisible Length: n = 4")
    void testMinimumDivisibleLength() {
        int[] input = {10, 20, 30, 40};
        int[] expected = {20, 30, 10, 40};

        codingPractice.rearrangeArray(input);

        assertArrayEquals(expected, input);
    }

    @ParameterizedTest(name = "Non-divisible length n = {0}")
    @MethodSource("provideNonDivisibleCases")
    @DisplayName("Test Array Lengths Not Divisible By 4")
    void testNonDivisibleLengths(int n, int[] input, int[] expected) {
        codingPractice.rearrangeArray(input);
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
        codingPractice.rearrangeArray(empty);
        assertArrayEquals(new int[]{}, empty);

        // n = 1
        int[] single = {42};
        codingPractice.rearrangeArray(single);
        assertArrayEquals(new int[]{42}, single);

        // n = 2
        int[] pair = {1, 2};
        codingPractice.rearrangeArray(pair);
        assertArrayEquals(new int[]{1, 2}, pair);

        // n = 3
        int[] trio = {1, 2, 3};
        codingPractice.rearrangeArray(trio);
        assertArrayEquals(new int[]{1, 2, 3}, trio);
    }

    @Test
    @DisplayName("Handling Negative and Duplicate Numbers")
    void testNegativeAndDuplicateNumbers() {
        int[] input = {-5, 0, -5, 10, 20, 30, -5, 100};
        int[] expected = {-5, 10, 20, 30, -5, 0, -5, 100};

        codingPractice.rearrangeArray(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testCommonCharsInOrder() {
        assertEquals("abcd", codingPractice.commonCharsInOrder("abcd", "dcba"));
        assertEquals("ape", codingPractice.commonCharsInOrder("apple", "peach"));
        assertEquals("abc", codingPractice.commonCharsInOrder("aabbcc", "abc"));
        assertEquals("aaaa", codingPractice.commonCharsInOrder("aaaa", "aaaa"));
        assertEquals("abcdef", codingPractice.commonCharsInOrder("abcdef", "fedcba"));
        assertEquals("abcd", codingPractice.commonCharsInOrder("aabbccdd", "bcda"));
        assertEquals("python", codingPractice.commonCharsInOrder("python", "thonpy"));
        assertEquals("iervew", codingPractice.commonCharsInOrder("interview", "review"));
        assertEquals("", codingPractice.commonCharsInOrder("aaaaa", "b"));
        assertEquals("", codingPractice.commonCharsInOrder("abc", "def"));
    }

    @Test
    public void testLongestCommonSuffix() {
        assertEquals("arking", codingPractice.longestCommonSuffix(new String[]{"barking", "parking", "starking"}));
        assertEquals("ower", codingPractice.longestCommonSuffix(new String[]{"flower", "tower", "power"}));
        assertEquals("a", codingPractice.longestCommonSuffix(new String[]{"alpha", "beta", "gamma"}));
        assertEquals("acer", codingPractice.longestCommonSuffix(new String[]{"racer", "placer", "effacer"}));
        assertEquals("ello", codingPractice.longestCommonSuffix(new String[]{"hello", "jello"}));
        assertEquals("word", codingPractice.longestCommonSuffix(new String[]{"word"}));
        assertEquals("apple", codingPractice.longestCommonSuffix(new String[]{"apple", "grapple", "pineapple"}));
        assertEquals("a", codingPractice.longestCommonSuffix(new String[]{"a", "aa", "aaa"}));
        assertEquals("", codingPractice.longestCommonSuffix(new String[]{"ab", "abc", "abcd"}));
        assertEquals("", codingPractice.longestCommonSuffix(new String[]{}));
        assertEquals("duction", codingPractice.longestCommonSuffix(new String[]{"introduction", "reduction", "production", "seduction"}));
        assertEquals("ation", codingPractice.longestCommonSuffix(new String[]{"communication", "station", "vacation", "nation"}));
        assertEquals("oon", codingPractice.longestCommonSuffix(new String[]{"spoon", "moon", "balloon", "cartoon", "raccoon"}));
        assertEquals("dabra", codingPractice.longestCommonSuffix(new String[]{"abracadabra", "dabra", "califragilisticexpialidociousdabra"}));
        assertEquals("mation", codingPractice.longestCommonSuffix(new String[]{"transformation", "information", "formation", "automation"}));
        assertEquals("eater", codingPractice.longestCommonSuffix(new String[]{"repeater", "defeater", "heater", "seater", "eater"}));
        assertEquals("ility", codingPractice.longestCommonSuffix(new String[]{"intelligibility", "responsibility", "agility", "ability"}));
        assertEquals("ization", codingPractice.longestCommonSuffix(new String[]{"synchronization", "organization", "localization", "realization"}));
        assertEquals("plication", codingPractice.longestCommonSuffix(new String[]{"complication", "application", "implication", "replication", "duplication"}));
        assertEquals("anding", codingPractice.longestCommonSuffix(new String[]{"understanding", "withstanding", "demanding", "commanding", "handing"}));
    }

    @Test
    public void testRepeatSubstring() {
        assertEquals("ab", codingPractice.repeatSubstring("ababab"));
        assertEquals("", codingPractice.repeatSubstring("abcab"));
        assertEquals("", codingPractice.repeatSubstring("abcab"));
        assertEquals("", codingPractice.repeatSubstring("abcabcab"));
        assertEquals("", codingPractice.repeatSubstring("abcabcabd"));
        assertEquals("zz", codingPractice.repeatSubstring("zzzz"));
        assertEquals("", codingPractice.repeatSubstring("#$#$$$#$#"));
        assertEquals("Python", codingPractice.repeatSubstring("PythonPythonPython"));
        assertEquals("", codingPractice.repeatSubstring("0"));
        assertEquals("", codingPractice.repeatSubstring("10011001100110011"));
        assertEquals("qwerty", codingPractice.repeatSubstring("qwertyqwertyqwerty"));
        assertEquals("aaaaa", codingPractice.repeatSubstring("aaaaaaaaaa"));
        assertEquals("", codingPractice.repeatSubstring("abababcbcbcbc"));
        assertEquals("abab", codingPractice.repeatSubstring("abababab"));
        assertEquals("11111", codingPractice.repeatSubstring("1111111111"));
        assertEquals("xyzxyzxyz", codingPractice.repeatSubstring("xyzxyzxyzxyzxyzxyz"));
        assertEquals("a".repeat(5000), codingPractice.repeatSubstring("a".repeat(10000)));
        assertEquals("bmbmbmbmbmbmbmbmbmbmb", codingPractice.repeatSubstring("bmbmbmbmbmbmbmbmbmbmbbmbmbmbmbmbmbmbmbmbmb"));
        assertEquals("lololo", codingPractice.repeatSubstring("lololololololololo"));
        assertEquals("abcdefghij", codingPractice.repeatSubstring("abcdefghijabcdefghijabcdefghij"));
        assertEquals("", codingPractice.repeatSubstring("y".repeat(999) + "z"));
        assertEquals("tut", codingPractice.repeatSubstring("tuttuttuttuttut"));
    }

    @Test
    public void testEfficient_LCP() {
        assertEquals("fl", codingPractice.efficient_LCP(new String[]{"floss", "flight", "floral"}));
        assertEquals("acorns", codingPractice.efficient_LCP(new String[]{"acorns", "acornsa", "acornsac", "acornsab"}));
        assertEquals("abcd", codingPractice.efficient_LCP(new String[]{"abcd", "abcd", "abcd", "abcd"}));
        assertEquals("a", codingPractice.efficient_LCP(new String[]{"abc", "a", "abcd"}));
        assertEquals("abcd", codingPractice.efficient_LCP(new String[]{"abcde", "abcdf"}));
        assertEquals("", codingPractice.efficient_LCP(new String[]{"tree", "treat", "break"}));
        assertEquals("", codingPractice.efficient_LCP(new String[]{"abcd", "efgh", "ijkl"}));
        assertEquals("appl", codingPractice.efficient_LCP(new String[]{"apple", "applied", "apply"}));
        assertEquals("appl", codingPractice.efficient_LCP(new String[]{"apply", "applan", "applet"}));
        assertEquals("", codingPractice.efficient_LCP(new String[]{"python", "java", "javascript"}));
        assertEquals("anim", codingPractice.efficient_LCP(new String[]{"animal", "animosity", "animate"}));
        assertEquals("so", codingPractice.efficient_LCP(new String[]{"song", "soprano", "sonar"}));
        assertEquals("cru", codingPractice.efficient_LCP(new String[]{"crumble", "crunched", "crust"}));
        assertEquals("", codingPractice.efficient_LCP(new String[]{"spring", "summer", "fall"}));
        assertEquals("", codingPractice.efficient_LCP(new String[]{"", "abcd", "wxyz"}));
        assertEquals("r", codingPractice.efficient_LCP(new String[]{"rotate", "rated", "rater"}));
        assertEquals("tas", codingPractice.efficient_LCP(new String[]{"tasmania", "task", "tassel"}));
        assertEquals("rock", codingPractice.efficient_LCP(new String[]{"rock", "rocket", "rocky"}));
        assertEquals("inv", codingPractice.efficient_LCP(new String[]{"invitation", "invigorating", "invalid"}));
        assertEquals("inter", codingPractice.efficient_LCP(new String[]{"intermingle", "intercept", "interchange"}));
    }

    @Test
    public void testFindMostCommonSubstring() {
        assertEquals("anaba", codingPractice.findMostCommonSubstring("bananabananaba", 5));
        assertEquals(".aa", codingPractice.findMostCommonSubstring("a.b.aa.ab.", 3));
        assertEquals("ab", codingPractice.findMostCommonSubstring("abcabcabc", 2));
        assertEquals("r", codingPractice.findMostCommonSubstring("zyxwvutsr", 1));
        assertEquals("demiol", codingPractice.findMostCommonSubstring("epidemiology", 6));
        assertEquals("abcd", codingPractice.findMostCommonSubstring("abcdabcdabcdabcdabcd", 4));
        assertEquals("lol", codingPractice.findMostCommonSubstring("lololololo", 3));
        assertEquals("a", codingPractice.findMostCommonSubstring("a", 1));
        assertEquals("a", codingPractice.findMostCommonSubstring("aa", 1));
        assertEquals("a", codingPractice.findMostCommonSubstring("abcdefgh", 1));
        assertEquals("abcdefgh", codingPractice.findMostCommonSubstring("abcdefgh", 8));
        assertEquals("xy", codingPractice.findMostCommonSubstring("xyzzyx", 2));
        assertEquals("abcd", codingPractice.findMostCommonSubstring("abcd", 4));
        assertEquals("a", codingPractice.findMostCommonSubstring("aaa", 1));
        assertEquals("ace", codingPractice.findMostCommonSubstring("racecar", 3));
        assertEquals("aaa", codingPractice.findMostCommonSubstring("aaabbb", 3));
    }

    @Test
    public void testMergeSortedLists_1() {
        List<Integer> l1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> l2 = Arrays.asList(2, 2, 3, 4, 6, 6);
        List<Integer> expected = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 9);
        assertEquals(expected, codingPractice.mergeSortedLists(l1, l2));
    }

    @Test
    public void testMergeSortedLists_2() {
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(1, 2, 3);
        List<Integer> expected = Arrays.asList(1, 1, 2, 2, 3, 3);
        assertEquals(expected, codingPractice.mergeSortedLists(l1, l2));
    }

    @Test
    public void testMergeSortedListsDescendingUnique() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(2, 3, 5, 6, 10);
        List<Integer> expected = Arrays.asList(10, 6, 5, 4, 3, 2, 1);
        assertEquals(expected, codingPractice.mergeSortedListsDescendingUnique(list1, list2));
    }

    @Test
    public void testRemoveCommonElements_1() {
        List<Integer> res = codingPractice.removeCommonElements(Arrays.asList(2, 5, 7, 10), Arrays.asList(1, 5, 9));
        assertEquals(Arrays.asList(1, 2, 7, 9, 10), res);
    }

    @Test
    public void testRemoveCommonElements_2() {
        List<Integer> res = codingPractice.removeCommonElements(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4));
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
        assertEquals(expected, codingPractice.mergeNSortedLists(input));
    }

    @Test
    public void testMergeNSortedLists_2() {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(111, 125, 143, 145),
                Arrays.asList(39, 128, 150, 160),
                Arrays.asList(58, 130, 166, 198)
        );
        List<Integer> expected = Arrays.asList(39, 58, 111, 125, 128, 130, 143, 145, 150, 160, 166, 198);
        assertEquals(expected, codingPractice.mergeNSortedLists(input));
    }
}
