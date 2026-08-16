package com.espboorg.effectiveJava.item4_noninstantiability;

public class Utility {
    public static void main(String[] args) {
        UtilityClass.run();
        // UtilityClass u = new UtilityClass();
        int[] arr = {0, 20, 2, 1, 11};
        UtilityClass.bubbleSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}

class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }

    public static void run() {
        System.out.println("Running");
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

/*  The private constructor prevents the class from being subclassed
class SubUtil extends UtilityClass {
}
 */