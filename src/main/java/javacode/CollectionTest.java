package javacode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionTest {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(10);
    list.add(8);
    System.out.println(list.peek());
    System.out.println(list.get(2));

    ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
    map.put(1, "one");
    map.put(2, "two");

    Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Integer, String> entry = iterator.next();
      try {
        if (entry.getKey() == 1) {
          map.remove(1);
        }
      } catch (ConcurrentModificationException ce) {
        ce.printStackTrace();
      }
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
    System.out.println(map.size());
  }
}
