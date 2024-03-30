package javacode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contamination {
    static Map<Integer, Set<Integer>> contaminatedMap = new HashMap<>();
    private static int[] positions = { 1, 3, 5, 9, 14, 15, 17, 20, 21, 24, 25, 26 };
    private static int safeDistance = 6;
    private static int minIndex;
    private static int maxIndex;
    private static int minVal = positions.length + 1;
    private static int maxVal = 0;
    public static void findMaxContaminatedRight(int positionIndex, Set<Integer> contaminated) {

        int nextIndex = positionIndex + 1;
        if (positionIndex < positions.length - 1) {
            int dR = positions[nextIndex] - positions[positionIndex];
            while (dR <= safeDistance) {
                contaminated.add(positions[nextIndex]);
                nextIndex++;
                if (nextIndex == positions.length)
                    break;
                dR = positions[nextIndex] - positions[positionIndex];

            }
        }
    }

    public static void findMaxContaminatedLeft(int positionIndex, Set<Integer> contaminated) {
        int previousIndex = positionIndex - 1;
        if (positionIndex > 0) {
            int dL = positions[positionIndex] - positions[previousIndex];
            while (dL <= safeDistance) {
                contaminated.add(positions[previousIndex]);
                previousIndex--;
                if (previousIndex < 0)
                    break;
                dL = positions[positionIndex] - positions[previousIndex];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Total no of people and distributed at following positions : "+positions.length);
        for (int element: positions) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
        System.out.println("Safe Distance given : "+safeDistance);
        for (int i = 0; i < positions.length; i++) {
            Set<Integer> contaminated = new HashSet<>();
            findMaxContaminatedRight(i, contaminated);
            contaminatedMap.put(positions[i], contaminated);

            findMaxContaminatedLeft(i, contaminated);
            contaminatedMap.put(positions[i], contaminated);

            if (minVal > contaminated.size()) {
                minVal = contaminated.size();
                minIndex = positions[i];
            }
            if (maxVal < contaminated.size()) {
                maxVal = contaminated.size();
                maxIndex = positions[i];
            }
        }
        System.out.println("worst case when infected person is at position "+ maxIndex + " : " +
                "will infect :"+ contaminatedMap.get(maxIndex).size() + " people, " +
                "they are at positions : "+contaminatedMap.get(maxIndex));
        System.out.println("best case when infected person is at position "+ minIndex + " : " +
                "will infect :"+ contaminatedMap.get(minIndex).size() + " people, " +
                "they are at positions : "+contaminatedMap.get(minIndex));
    }
}
