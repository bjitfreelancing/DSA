package javacode.rules;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RuleEngine {
    private static Map<String, Rules> rulesMap = new HashMap<>();

    public static Map<String, Rules> parseRules() {
        try {
            Scanner scanner = new Scanner(
                    new File("/Users/biswajit/workspace/DSA/src/main/java/javacode/rules/ruleengine.csv"));
            //scanner.useDelimiter(",");
            int i = 1;
            while (scanner.hasNextLine()) {
                Rules rules = new Rules();
                String line = scanner.nextLine();
                String[] words = line.split(",");
                for (String word: words) {
                    rules.addInput(word);
                }
                rules.setOutput(words[words.length - 1]);
                rules.getInputs().removeLast();
                rulesMap.put("Rule"+i, rules);
                i++;
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rulesMap;
    }

    public static String route(String rules) {

        String[] rulesArr = rules.split(",");

        for (Rules rule : rulesMap.values()) {
            System.out.println("rulesMap.value: "+rule.toString());
            int index = 0;
            if (rulesArr.length == rule.getInputs().size()) {
                boolean flag = true;
                for (String input : rule.getInputs()) {
                    if (!input.contains("*") && !rulesArr[index].equals(input)) {
                        flag = false;
                    }
                    index++;
                }
                if (flag) {
                    return "Input maps with an existing rule engine " +
                            "and the output is : " + rule.getOutput();
                }

            }
        }
        return null;
    }
    public static void main(String[] args) {
        parseRules();

        String output = route("prod1, aa, ca1");
        if (Objects.nonNull(output)) {
            System.out.println(output);
        } else {
            System.out.println("Invalid Rule");
        }
    }
}
