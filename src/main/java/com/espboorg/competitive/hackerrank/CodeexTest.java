package com.espboorg.competitive.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeexTest {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        System.out.println(findNumber(arr, 8));
        System.out.println(oddNumbers(1, 20));

        List<String> pangram = new ArrayList<>();
        pangram.add("");
        pangram.add("pack my box with five dozen liquor jugs");
        System.out.println(isPangram(pangram));

        List<String> rocks = new ArrayList<>();
        rocks.add("abcdde");
        rocks.add("baccd");
        rocks.add("eeabg");
        System.out.println(gemstones(rocks));
    }

    public static String findNumber(List<Integer> arr, int k) {
        for (Integer el : arr) {
            if (el == k) {
                return "YES";
            }
        }
        return "NO";
    }

    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> arr = new ArrayList<>();
        for (int i = l; i < r; i++) {
            if (i % 2 != 0) {
                arr.add(i);
            }
        }
        return arr;
    }

    public static String isPangram(List<String> pangram) {
        long a = System.currentTimeMillis();
        StringBuilder retVal = new StringBuilder();
        for (String word : pangram) {
            if (checkIfPangram(word)) {
                retVal.append(1);
            } else {
                retVal.append(0);
            }
        }
        System.out.println("Execution of isPangram() took " + (System.currentTimeMillis() - a) + " ms.");
        return retVal.toString();
    }

    private static boolean checkIfPangram(String word) {
        int a = 'a';
        int z = 'z';
        for (int i = a; i <= z; i++) {
            if (word.indexOf(i) == -1) {
                return false;
            }
        }
        return true;
    }

    public static int gemstones(List<String> rocks) {
        long a = System.currentTimeMillis();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (String line : rocks) {
            findGemstones(line, map);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == rocks.size()) {
                count++;
            }
        }
        System.out.println("Execution of gemstones() took " + (System.currentTimeMillis() - a) + " ms.");
        return count;
    }

    private static void findGemstones(String line, Map<Integer, Integer> map) {
        int a = 'a';
        int z = 'z';
        int[] az = new int[z + 1];
        for (int i = 0; i < line.length(); i++) {
            int index = line.charAt(i);
            if (az[index] == 0) {
                az[index]++;
            }
        }
        for (int i = 0; i < az.length; i++) {
            if (az[i] > 0) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
        }
    }
}

