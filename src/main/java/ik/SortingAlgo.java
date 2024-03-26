package ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortingAlgo {

    public static void main(String[] args) {
        int[] A = {6,9, 13, 14, 2, 8, 11, 5, 4, 3, 1};
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(A)     // IntStream
                .boxed()        // Stream<Integer>
                .collect(Collectors.toList());
        ArrayList<Integer> list1 = segregate_evens_and_odds(list);
        for (Integer i : list1) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        int n = A.length;
        int start = 0, end = n-1;
        int mid = (start + end)/2;
        System.out.println(mid + " : "+A[mid]);
    }

    //Given an array of numbers, rearrange them in-place
    // so that even numbers appear before odd ones.
    static ArrayList<Integer> segregate_evens_and_odds(ArrayList<Integer> numbers) {
        // Write your code here.
        int n = numbers.size();
        int left = 0;
        int right = n-1;

        while (right >= left) {
            if (numbers.get(left) % 2 != 0) {
                //needs to be swapped and right
                int temp = numbers.get(left);
                numbers.set(left, numbers.get(right));
                numbers.set(right, temp);
                right--;
            } else {
                left++;
            }
        }
        return numbers;
    }

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        // Write your code here.
        return new ArrayList();
    }
}
