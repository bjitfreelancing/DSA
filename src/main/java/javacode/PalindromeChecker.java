package javacode;

import java.util.List;
import java.util.stream.Collectors;

public class PalindromeChecker {

  public static boolean isPalindrome(String str) {
    str = str.toLowerCase();
    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    String str1 = "A man, a plan, a canal, Panama!";
    String str2 = "racecar";
    String str3 = "hello";

    System.out.println("\"" + str1 + "\" is a palindrome: " + isPalindrome(str1));
    System.out.println("\"" + str2 + "\" is a palindrome: " + isPalindrome(str2));
    System.out.println("\"" + str3 + "\" is a palindrome: " + isPalindrome(str3));
//    int P = 5;
//    int T = 8;
    int P = 0;
    int T = 3;
    System.out.println("Traversing forward/clockwise and printing intermediaries ......");
    if (T >= P) {
      while (++P < T) {
        System.out.println("      " + P);
      }
    } else {
      while (++P <= 9) {
        System.out.println("      " + P);
      }
      P = 0;
      System.out.println("      " + 0);
      while (++P < T) {
        System.out.println("      " + P);
      }
    }

//    P = 5;
//    T = 8;
    P = 9;
    T = 3;
    System.out.println("Traversing backward/anti-clockwise and printing intermediaries ......");
      if (T <= P) {
        while (--P > T) {
          System.out.println("      " + P);
        }
      } else {
        while (--P >= 0) {
          System.out.println("      " + P);
        }

        P = 9;
        System.out.println("      " + 9);
        while (--P > T) {
          System.out.println("      " + P);
        }

      }
    int num = 1234567;
    List<Integer> digits = Integer.toString(num).chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    for(int d : digits)
      System.out.print(d);
  }
}
