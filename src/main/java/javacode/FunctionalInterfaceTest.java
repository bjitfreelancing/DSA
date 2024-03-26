package javacode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Functional Interface using lambda function
 */
public class FunctionalInterfaceTest {

  interface FuncInterface {
    void show(String x);
  }

  interface OperateFuncInterface {
    int operate(int x, int y);
  }

  private int operate(int x, int y, OperateFuncInterface operFuncInterface) {
    return operFuncInterface.operate(x, y);
  }
  public static void main(String[] args) {
    OperateFuncInterface add = (int x, int y) -> {
      System.out.println("x: "+x+" y: "+y);
      return x + y;
    };

    OperateFuncInterface multi = (int x, int y) -> x * y;

    FunctionalInterfaceTest test = new FunctionalInterfaceTest();
    System.out.println("Add: "+ test.operate(10, 20, add));
    System.out.println("Mult: "+ test.operate(100, 20, multi));
    System.out.println("Mult: "+ multi.operate(200, 30));

    List<Integer> al = new ArrayList<>();
    al.add(205);
    al.add(102);
    al.add(98);
    al.add(275);
    al.add(203);
    System.out.println("Elements of the ArrayList " +
        "before sorting : " + al);
    // using lambda expression in place of comparator object
    Collections.sort(al, (o1, o2) -> (o1 > o2) ? 1 : (o1 < o2) ? -1 : 0);
    System.out.println("Elements of the ArrayList " +
        "after sorting : " + al);
    FuncInterface show = message -> System.out.println("Finshed, "+message);
    show.show("The demo");
  }
}
