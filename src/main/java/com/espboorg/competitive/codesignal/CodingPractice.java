package com.espboorg.competitive.codesignal;

import java.util.*;

public class CodingPractice {

    // Standard Math Algorithms in Java

    /**
     * Java function that checks whether both a and b are coprime or not.
     * Two numbers are said to be coprime or mutually prime if the only positive integer that divides both of them is 1.
     *
     * @param a int
     * @param b int
     * @return true if both are coprime; false otherwise
     */
    public boolean areCoprime(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Inputs must be positive integers.");
        }

        int target = Math.min(a, b);
        int other = Math.max(a, b);

        if (target % 2 == 0) {
            if (other % 2 == 0) {
                return false;
            }
            while (target % 2 == 0) {
                target /= 2;
            }
        }

        for (int i = 3; i * i <= target; i += 2) {
            if (target % i == 0) {
                if (other % i == 0) {
                    return false;
                }
                while (target % i == 0) {
                    target /= i;
                }
            }
        }

        return target <= 1 || other % target != 0;
    }

    /**
     * Method returns the n-th prime number
     *
     * @param n int
     * @return n-th prime number
     */
    public int nthPrime(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Inputs must be positive integers.");
        }
        if (n == 1) {
            return 2;
        }

        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);

        int i = 3;
        while (primeNumbers.size() < n) {
            if (isNextPrime(i, primeNumbers)) {
                primeNumbers.add(i);
            }
            i += 2;
        }
        return primeNumbers.get(n - 1);
    }

    private boolean isNextPrime(int number, List<Integer> primeNumbers) {
        for (int i : primeNumbers) {
            if (i * i > number) {
                break;
            }
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the zero-based index of the first occurrence of a specific value in the list
     *
     * @param list List
     * @param val  int
     * @return index of the first occurrence of a specific value, if the value isn't found, return -1
     */
    public int indexOfFirstOccurrence(List<Integer> list, int val) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == val) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method counts unique elements in the given list
     *
     * @param nums list
     * @return count of unique elements
     */
    public int countUniqueElements(List<Integer> nums) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < nums.size(); j++) {
                if (i != j && Objects.equals(nums.get(i), nums.get(j))) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                count++;
            }
        }
        return count;
    }

    /**
     * Return the reversed list of integers
     *
     * @param numbers list of integers
     * @return reversed list of integers
     */
    public List<Integer> reverseList(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return numbers;
        }

        Integer[] intArray = numbers.toArray(Integer[]::new);

        for (int i = 0; i < intArray.length / 2; i++) {
            int temp = intArray[i];
            intArray[i] = intArray[intArray.length - 1 - i];
            intArray[intArray.length - 1 - i] = temp;
        }
        return Arrays.asList(intArray);
    }

    /**
     * Method should shift every element in the list
     * to the right (for a positive shift) or
     * to the left (for a negative shift) by shift positions.
     * The shift should be circular — the last element should be moved
     * to the start of the list if shift is positive, and vice versa.
     *
     * @param integerList the list
     * @param shift       shift positions
     * @return shifted list
     */
    public List<Integer> shiftListElements(List<Integer> integerList, int shift) {
        if (integerList == null || integerList.isEmpty()) {
            return new ArrayList<>();
        }

        int size = integerList.size();

        int effectiveShift = ((shift % size) + size) % size;

        if (effectiveShift == 0) {
            return new ArrayList<>(integerList);
        }

        int[] shiftedArray = new int[size];
        for (int index = 0; index < size; index++) {
            shiftedArray[(index + effectiveShift) % size] = integerList.get(index);
        }

        List<Integer> result = new ArrayList<>(size);
        for (int val : shiftedArray) {
            result.add(val);
        }

        return result;
    }

    /**
     * Determines if listB is a contiguous subarray of listA.
     *
     * @param listA list
     * @param listB list
     * @return true if listB is a contiguous subarray of listA, and false otherwise
     */
    public boolean contiguousSubarray(int[] listA, int[] listB) {
        if (listB.length == 0) {
            return true;
        }

        if (listB.length > listA.length) {
            return false;
        }

        int maxStartIndex = listA.length - listB.length;
        for (int i = 0; i < maxStartIndex; i++) {
            if (listB[0] == listA[i]) {
                if (isContiguous(listA, listB, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isContiguous(int[] listA, int[] listB, int index) {
        for (int i = 0; i < listB.length; i++) {
            if (index + i >= listA.length || listA[index + i] != listB[i]) {
                return false;
            }
        }
        return true;
    }


    // Simple Recursion in Practice

    /**
     * Recursive function that takes an integer n as an input and
     * returns a list of integers from n to 1, inclusive, in decreasing order.
     *
     * @param n integer
     * @return a list of integers from n to 1
     */
    public List<Integer> generateListFromNTo1(int n) {
        if (n == 1) {
            List<Integer> list = new LinkedList<>();
            list.add(n);
            return list;
        }
        List<Integer> generatedListFromNTo1 = generateListFromNTo1(n - 1);
        generatedListFromNTo1.addFirst(n);

        return generatedListFromNTo1;
    }

    /**
     * Recursive function that returns the sum of all the digits in n
     * raised to the power of their respective positions (1-indexed from the right)
     *
     * @param n positive integer
     * @return the sum
     */
    public int sumOfDigitsRaisedToPositions(int n) {
        return sumOfDigitsRaisedToPositionsHelper(n, 1);
    }

    private int sumOfDigitsRaisedToPositionsHelper(int n, int position) {
        if (n < 10) {
            return power(n, position);
        }
        int digit = n % 10;
        int powered = power(digit, position);
        return powered + sumOfDigitsRaisedToPositionsHelper(n / 10, position + 1);
    }

    private int power(int n, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= n;
        }
        return result;
    }

    /**
     * Reverses a given string s using recursion
     *
     * @param s String
     * @return reversed String
     */
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    /**
     * Utilizes recursion to find the Fibonacci number at the index n.
     *
     * @param n index
     * @return Fibonacci number at the index n
     */
    public long fibonacci(int n) {
        List<Long> fibonacciList = new ArrayList<>();
        fibonacciList.add(0L);
        fibonacciList.add(1L);

        return fibonacciHelper(n, fibonacciList);
    }

    private long fibonacciHelper(int n, List<Long> fibonacciList) {
        if (n < fibonacciList.size()) {
            return fibonacciList.get(n);
        }
        fibonacciList.add(fibonacciHelper(n - 1, fibonacciList) + fibonacciHelper(n - 2, fibonacciList));
        return fibonacciList.get(n);
    }


    // Simple Matrix Practice in Java

    /**
     * Indicates whether the matrix is a Toeplitz matrix
     *
     * @param matrix matrix of n×n size
     * @return true if all diagonals that run from the top-left to the bottom-right (↘ direction) are constant
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int length = matrix.length;
        int width = matrix[0].length;
        if (length != width) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; i + k < length && j + k < width; k++) {
                    if (matrix[i][j] != matrix[i + k][j + k]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Counts the number of integers in the matrix that are smaller than the given target
     *
     * @param matrix a matrix where each row and column are sorted in ascending order
     * @param target given target
     * @return count of integers smaller than the given target
     */
    public int countLessThan(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int count = 0;
        int row = 0;
        int col = numCols - 1;

        while (row < numRows && col >= 0) {
            if (matrix[row][col] < target) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }

    /**
     * Finds the minimum and maximum values at the secondary diagonal of a 2D matrix.
     * The secondary diagonal starts in the top right corner and ends in the bottom left corner.
     *
     * @param grid 2D matrix
     * @return list of two elements where the first element is the minimum value, and the second is the maximum value
     */
    public List<Integer> minMaxInSecondaryDiagonal(int[][] grid) {
        if (grid == null) {
            return Arrays.asList(null, null);
        }
        int rows = grid.length;
        if (rows == 0) {
            return Arrays.asList(null, null);
        }
        int cols = grid[0].length;
        if (cols == 0) {
            return Arrays.asList(null, null);
        }

        int i = 0;
        int j = cols - 1;

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        while (i < rows && j >= 0) {
            if (grid[i][j] > maximum) {
                maximum = grid[i][j];
            }
            if (grid[i][j] < minimum) {
                minimum = grid[i][j];
            }
            i++;
            j--;
        }

        return Arrays.asList(minimum, maximum);
    }

    public Integer findRowWithTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int row = 0;
        int col = numCols - 1;

        while (row < numRows && col >= 0) {
            if (matrix[row][col] == target) {
                return row;
            }
            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return null;
    }


    // Advanced Array Manipulation Techniques

    /**
     * Reverse the array
     *
     * @param arr array
     * @return reversed array
     */
    public int[] reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        return reverseArray(arr, start, end);
    }

    private int[] reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    /**
     * Anti-clockwise rotation of the array nums by k steps
     *
     * @param nums array
     * @param k    steps
     */
    public void antiRotateArray(int[] nums, int k) {
        int size = nums.length;

        int shift = k % size;
        while (shift > 0) {
            shiftLeftByOne(nums, size);
            shift--;
        }
    }

    private void shiftLeftByOne(int[] nums, int size) {
        int temp = nums[0];

        for (int i = 0; i < size; i++) {
            if (i + 1 < size) {
                nums[i] = nums[i + 1];
            } else if (i + 1 == size) {
                nums[i] = temp;
            }
        }
    }

    /**
     * Shuffles the array in such a way that, starting from the first element,
     * every k-th element moves to the end of the array.
     *
     * @param nums list of integers
     * @param k    k-th element
     * @return shuffled list of integers
     */
    public List<Integer> shuffleArray(List<Integer> nums, int k) {
        if (k == 0 || k == nums.size()) {
            return nums;
        }

        k = k % nums.size();

        int size = nums.size();
        for (int i = k - 1; i < size; i += k - 1) {
            shiftLeftByOne(nums, i);
            size--;
        }
        return nums;
    }

    private void shiftLeftByOne(List<Integer> nums, int startIndex) {
        int temp = nums.get(startIndex);

        for (int i = startIndex; i < nums.size(); i++) {
            if (i + 1 < nums.size()) {
                nums.set(i, nums.get(i + 1));
            } else if (i + 1 == nums.size()) {
                nums.set(i, temp);
            }
        }
    }

    /**
     * Reverses the array in groups of k size, and if the last group has fewer than k elements, reverse all of them.
     *
     * @param numbers array of integers
     * @param k       size of groups
     * @return the newly organized array after the groups have been reversed
     */
    public int[] reverseArrayInGroups(int[] numbers, int k) {
        if (k == 0 || k == 1) {
            return numbers;
        }

        for (int i = 0, j = k - 1; i < numbers.length; i += k, j += k) {
            if (j >= numbers.length) {
                j = numbers.length - 1;
            }
            reverseArray(numbers, i, j);
        }
        return numbers;
    }

    /**
     * Rearranges the array so that the middle half of the elements
     * (considering the left and right quarters have been eliminated) move to the beginning of the array.
     * The remaining elements, the left and right quarters, should move to the end of the array.
     * If n is not divisible by 4, include the extra elements in the middle half.
     *
     * @param nums array of integers
     */
    public void rearrangeArray(int[] nums) {
        if (nums == null || nums.length < 4) {
            return;
        }

        int size = nums.length;
        int quarter = size / 4;
        int middleEnd = size - 1 - quarter;

        // Left-rotate the subarray [0 .. middleEnd] by `quarter` positions
        // Step 1: Reverse entire segment [Q1 + Middle]
        reverseArray(nums, 0, middleEnd);

        // Step 2: Reverse the Middle portion back to original order
        reverseArray(nums, 0, middleEnd - quarter);

        // Step 3: Reverse the Q1 portion back to original order
        reverseArray(nums, middleEnd - quarter + 1, middleEnd);
    }

    /**
     * Determine a new string, string3, that is formed by characters
     * that occur in both string1 and string2 in the same order as they occur in string1.
     * Algorithm should not exceed a time complexity of O(n + m)
     *
     * @param string1 String
     * @param string2 String
     * @return String containing common occurring characters
     */
    public String commonCharsInOrder(String string1, String string2) {
        int[] count = new int[256];
        for (int i = 0; i < string2.length(); i++) {
            char c = string2.charAt(i);
            count[c]++;
        }

        StringBuilder string3 = new StringBuilder();
        for (int i = 0; i < string1.length(); i++) {
            char c = string1.charAt(i);
            if (count[c] > 0) {
                string3.append(c);
                count[c]--;
            }
        }
        return string3.toString();
    }

    /**
     * Find the longest common suffix shared among all strings in the array.
     *
     * @param words array of strings
     * @return common suffix, or an empty string If the given array is empty or there is no common suffix
     */
    public String longestCommonSuffix(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        String shortest = words[0];
        for (String s : words) {
            if (s.length() < shortest.length()) {
                shortest = s;
            }
        }

        for (int i = 0; i < shortest.length(); i++) {
            for (String str : words) {
                char charToCheck = shortest.charAt(shortest.length() - 1 - i);
                if (str.charAt(str.length() - 1 - i) != charToCheck) {
                    return shortest.substring(shortest.length() - i);
                }
            }
        }
        return shortest;
    }

    /**
     * Checks whether the string s consists of one repeated substring
     *
     * @param s string
     * @return the longest repeating substring
     */
    public String repeatSubstring(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }

        int length = s.length();
        for (int i = length / 2; i > 0; i--) {
            if (length % i == 0) {
                String pattern = s.substring(0, i);
                if (pattern.repeat(length / i).equals(s)) {
                    return pattern;
                }
            }
        }
        return "";
    }

    /**
     * Find the longest common prefix in the given array of strings
     *
     * @param words array of strings
     * @return longest common prefix
     */
    public String efficient_LCP(String[] words) {
        if (words.length == 0) return "";

        Arrays.sort(words);

        String first = words[0];
        String last = words[words.length - 1];

        int i = 0;
        int maxIndex = Math.min(first.length(), last.length());

        while (i < maxIndex && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }

    /**
     * Finds and returns the most common substring of a given length in the input string.
     * If two or more substrings have the same maximum frequency, returns the lexicographically smallest one.
     *
     * @param s      input string
     * @param length substring length
     * @return most common substring
     */
    public String findMostCommonSubstring(String s, int length) {
        if (s == null || length <= 0 || length > s.length()) {
            return "";
        }
        if (s.length() == length) {
            return s;
        }

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i + length <= s.length(); i++) {
            String pattern = s.substring(i, i + length);
            frequencyMap.merge(pattern, 1, Integer::sum);
        }

        return retrieveMostCommonSubstring(frequencyMap);
    }

    private String retrieveMostCommonSubstring(Map<String, Integer> frequencyMap) {
        int maxFrequency = 0;
        String mostCommonSubstring = "";
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            String key = entry.getKey();

            if (entry.getValue() > maxFrequency) {
                maxFrequency = frequency;
                mostCommonSubstring = key;
            } else if (maxFrequency == frequency && key.compareTo(mostCommonSubstring) < 0) {
                mostCommonSubstring = key;
            }
        }
        return mostCommonSubstring;
    }
}
