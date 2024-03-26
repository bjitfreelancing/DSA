package javacode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
  public static void main(String[] args) {
    String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+]).{8,20}$";
//    String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
    Pattern pattern = Pattern.compile(regex);
    String input = "Chaiti270374$";
    Matcher matcher = pattern.matcher(input);
    if (matcher.find())
      System.out.println("Pattern found");
  }
}
