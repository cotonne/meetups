package domain;

/**
 * Created by user on 23/10/2016.
 */
public class Value {
    private String variableName;
    private int value;

    public Value(String variableName, int value) {
        this.variableName = variableName;
        this.value = value;
    }

    public String getVariableName() {
        return variableName;
    }

    public int getValue() {
        return value;
    }
}
