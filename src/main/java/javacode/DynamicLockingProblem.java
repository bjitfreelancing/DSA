package javacode;

import java.util.List;
import java.util.stream.Collectors;

public class DynamicLockingProblem {
  // Target Digit - T, Present Digit - P
  // Max path traversed from P -> T for each digit in the wheel is 5
  // The traversal canbe forward/clockwise or backward/anti-clockwise
  // We need to find the either one of the shorter path to reach from P -> T


  private static int maxTraversed = 5;

  public static void main(String[] args) {
    int start = 2049;
    int lock = 6761;
    System.out.println("Your lock is : "+lock + " and your random number: "+start);
    findMinimalPath(start, lock);
  }

  private static void findMinimalPath(Integer present, Integer targetLock) {
    //Considering 4 digit locks
    List<Integer> presentDigits = Integer.toString(present).chars().map(Character::getNumericValue).boxed().collect(
        Collectors.toList());
    List<Integer> targetLockDigits = Integer.toString(targetLock).chars().map(Character::getNumericValue).boxed().collect(
        Collectors.toList());

    for (int i = 0; i < presentDigits.size(); i++ ) {
      System.out.println("Traversing for digit position "+i+" :: present digit: "+presentDigits.get(i) + " target digit: "+targetLockDigits.get(i));
      decidePath(presentDigits.get(i), targetLockDigits.get(i));
    }
  }
  private static void decidePath(int P, int T) {
    if (T >= P ) {
      if (T-P <= 5) {
        //Move forward/clockwise
        traverseForward(P, T);
      } else {
        //Move backward/anti-clockwise
        traverseBackward(P, T);
      }

    } else {
      if (P-T >= 5) {
        //Move forward/clockwise
        traverseForward(P, T);
      } else {
        //Move backward/anti-clockwise
        traverseBackward(P, T);
      }
    }
  }
  public static void traverseForward(int P, int T) {
    System.out.println("Traversing forward/clockwise, printing intermediaries before reaching to target : "+T);
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
  }

  public static void traverseBackward(int P, int T) {
    System.out.println("Traversing backward/anti-clockwise, printing intermediaries before reaching to target : "+T);
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
  }

  private class CircularQueue {
    private int[] queue;
    private int front, rear;

    private CircularQueue() {
      queue = new int[10];
      for (int i=0; i<10; i++) {
        queue[i] = i;
      }
    }
  }
}
