package javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortingAlgos {

    public static void main(String[] args) {
        int[] A = {6,9, 2, 8, 5, 4, 3};
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(A)     // IntStream
                .boxed()        // Stream<Integer>
                .collect(Collectors.toList());
        printArray(list);
        list = selection_sort(list);
        for (Integer a: list) {
            System.out.print(a + " ");
        }
    }

    public static void printArray(ArrayList<Integer> arr) {
        for (Integer a:arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static ArrayList<Integer> selection_sort(ArrayList<Integer> arr) {
        System.out.println("Selection Sort.. Brute Sorting algorithm");
        int n = arr.size();

        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);
        }
        printArray(arr);
        return arr;
    }
}
