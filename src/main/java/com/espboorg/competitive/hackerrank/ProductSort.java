package com.espboorg.competitive.hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Solution {

    /*
     * Complete the 'itemsSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY items as parameter.
     */

    public static List<Integer> itemsSort(List<Integer> items) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> temp = new ArrayList<>();
        for (Integer key : items) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
                continue;
            }
            map.put(key, 1);
        }
        Collections.sort(items);
        for (int i = 1; i < items.size(); i++) {
            for (Integer key : items) {
                if (map.get(key) == i) {
                    temp.add(key);
                }
            }
        }
        return temp;
    }

}

public class ProductSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int itemsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> items = IntStream.range(0, itemsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Solution.itemsSort(items);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
