package javacode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
  public static void sockMerchant(int n, List<Integer> ar) {
    // Write your code here
    Map<Integer, Integer> colourPair = new HashMap<>();
    for (Integer c : ar) {
      if (colourPair.containsKey(c)) {
        colourPair.put(c, colourPair.get(c) + 1);
      } else
        colourPair.put(c, 1);
    }

  }
}
