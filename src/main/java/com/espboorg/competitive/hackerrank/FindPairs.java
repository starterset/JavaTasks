package com.espboorg.competitive.hackerrank;

import java.util.*;

public class FindPairs {
    public static void main(String[] args) {
        final int EXECUTION_TIMES = 100;
        List<Integer> numbers12 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3));
        List<Integer> nums = new ArrayList<>(Arrays.asList(6, 4, 1, 3, 5, 2));
        List<Integer> nus = new ArrayList<>(Arrays.asList(1, 2, 5, 6, 9, 10));
        List<Integer> numbersBig = new ArrayList<>();
        List<Integer> numbersBigShuffled = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            numbersBig.add(i);
            numbersBigShuffled.add(i);
        }
        Collections.shuffle(numbersBigShuffled);

        long time = System.currentTimeMillis();
        for (int i = 0; i < EXECUTION_TIMES; i++) {
            System.out.println("Count of pairs: " + PairUtil.countPairs(numbers12, 1));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairs(numbers, 1));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairs(nums, 2));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairs(nus, 2));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairs(numbersBig, 2));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairs(numbersBigShuffled, 2));
            System.out.println();
        }
        long countPairsTime = System.currentTimeMillis() - time;

        time = System.currentTimeMillis();
        for (int i = 0; i < EXECUTION_TIMES; i++) {
            System.out.println("Count of pairs: " + PairUtil.countPairsOther(numbers12, 1));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairsOther(numbers, 1));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairsOther(nums, 2));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairsOther(nus, 2));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairsOther(numbersBig, 2));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairsOther(numbersBigShuffled, 2));
            System.out.println();
        }
        long countPairsOtherTime = System.currentTimeMillis() - time;

        time = System.currentTimeMillis();
        for (int i = 0; i < EXECUTION_TIMES; i++) {
            System.out.println("Count of pairs: " + PairUtil.countPairsBrutForce(numbers12, 1));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairsBrutForce(numbers, 1));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairsBrutForce(nums, 2));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairsBrutForce(nus, 2));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairsBrutForce(numbersBig, 2));
            System.out.println();

            System.out.println("Count of pairs: " + PairUtil.countPairsBrutForce(numbersBigShuffled, 2));
            System.out.println();
        }

        System.out.println("execution of countPairs() took " + countPairsTime + "ms");
        System.out.println("execution of countPairsOther() took " + countPairsOtherTime + "ms");
        System.out.println("execution of countPairsBrutForce() took " + (System.currentTimeMillis() - time) + "ms");
    }
}

class PairUtil {
    public static int countPairs(List<Integer> numbers, int k) {
        Collections.sort(numbers);
        Set<Pair> pairs = new HashSet<>();
        int iterationCount = 0;
        for (int i = 0, j = 0; i < numbers.size() && j < numbers.size(); ) {
            iterationCount++;

            int a = numbers.get(i);
            int b = numbers.get(j);
            if (a + k == b) {
                pairs.add(new Pair(a, b));
                i++;
                j++;
            } else if (a + k < b) {
                i++;
            } else if (a + k > b) {
                j++;
            }
        }

        System.out.println("countPairs() iteration count: " + iterationCount);
        return pairs.size();
    }

    public static int countPairsOther(List<Integer> numbers, int k) {
        Set<Pair> pairs = new HashSet<>();
        int iterationCount = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = numbers.size() - 1; j >= i; j--) {
                iterationCount++;

                int a = numbers.get(i);
                int b = numbers.get(j);
                if (a + k == b) {
                    pairs.add(new Pair(a, b));
                }
            }
        }
        System.out.println("countPairsOther() iteration count: " + iterationCount);
        return pairs.size();
    }

    public static int countPairsBrutForce(List<Integer> numbers, int k) {
        Set<Pair> pairs = new HashSet<>();
        int iterationCount = 0;
        for (int a : numbers) {
            for (int b : numbers) {
                iterationCount++;
                if (a + k == b) {
                    pairs.add(new Pair(a, b));
                }
            }
        }
        System.out.println("countPairsBrutForce() iteration count: " + iterationCount);
        return pairs.size();
    }
}

record Pair(int p, int k) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (p != pair.p) return false;
        return k == pair.k;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, k);
    }
}
