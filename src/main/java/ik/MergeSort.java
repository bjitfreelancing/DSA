package ik;
//Divide and Conquer
// Step 1: Dividing the List Into Two Smaller Sublists.
//          make a recursive call to sort the sublists.
//          This process continues until the size of the list reduces to 1.
// Step 2: Merging the Sublists to Produce the Sorted List


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {
    public static void main(String[] args) {
        int[] A = {6, 9, 13, 14, 2, 8, 11, 5, 4, 3, 1};
        ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(A)     // IntStream
                .boxed()        // Stream<Integer>
                .collect(Collectors.toList());
        divide(arr, 0, arr.size() - 1);
        System.out.println(arr);
    }
    private static void divide(ArrayList<Integer> arr, int start, int end) {
        // Divide means finding out start, mid, end till leaves, mid is changing
        if (start < end) {// This is not while loop, as this is DFS
            int mid = (end + start)/2;
            divide(arr, start, mid);
            divide(arr, mid+1, end);

            merge(arr, start, mid, end);
        }

    }
    private static void merge(ArrayList<Integer> arr, int start, int mid, int end) {
        //Merge means merging 2 halves, hence interested of 1 half of start-mid, another mid+1 - end
        int[] l = new int[mid - start + 1];
        int[] r = new int[end - mid];
        for (int i = 0; i < mid - start + 1; i++) {
            l[i] = arr.get(start + i);
        }
        for (int i = 0; i < end - mid; i++) {
            r[i] = arr.get(mid + i + 1);
        }
        int i = 0, j = 0, k = start;
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                arr.set(k, l[i]);
                i++;
            }else {
                arr.set(k, r[j]);
                j++;
            }
            k++;
        }

        while (i < l.length) {
            arr.set(k++, l[i++]);
        }
        while (j < r.length) {
            arr.set(k++, r[j++]);
        }
    }

}
