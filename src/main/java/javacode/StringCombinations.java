package javacode;

public class StringCombinations {
  private static void printCombinationsHelper(String str, String prefix, int start) {
    System.out.println("prefix: "+prefix); // Print the current combination
    System.out.println("start: "+start);
    for (int i = start; i < str.length(); i++) {
      System.out.println("i: "+i);
      printCombinationsHelper(str, prefix + str.charAt(i), i + 1);
    }
  }

  public static void printCombinations(String str) {
    if (str == null || str.length() == 0) {
      return;
    }
    printCombinationsHelper(str, "", 0);
  }

  public static void main(String[] args) {
    String str = "abc";
    System.out.println("Combinations of string '" + str + "':");
    printCombinations(str);
  }
}
