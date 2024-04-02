package javacode.rules;

import java.util.ArrayList;
import java.util.List;

public class Rules {
    List<String> inputs = new ArrayList<>();
    String output;

    public List<String> getInputs() {
        return inputs;
    }

    public void addInput(String input) {
        inputs.add(input);
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    public String toString() {
        return "inputs: "+this.inputs + " output: " + this.output;
    }
}
