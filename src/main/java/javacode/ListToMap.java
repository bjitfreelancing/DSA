package javacode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToMap {
  class ListItems {


    private Integer key;

    public ListItems(Integer key, String value) {
      this.key = key;
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    private String value;

    public Integer getKey() {
      return key;
    }

    public void setKey(Integer key) {
      this.key = key;
    }
  }
  private void populate() {
    List<ListItems> list = new ArrayList<>();
    list.add(new ListItems(1, "I"));
    list.add(new ListItems(2, "Love"));
    list.add(new ListItems(3, "Geeks"));
    list.add(new ListItems(4, "For"));
    list.add(new ListItems(5, "Geeks"));

    Map<Integer, String> map = new HashMap<>();
    list.forEach((l) -> map.put(l.getKey(), l.getValue()));
    System.out.println("Map : " + map);
  }
  public static void main(String[] args) {
    new ListToMap().populate();
  }
}
