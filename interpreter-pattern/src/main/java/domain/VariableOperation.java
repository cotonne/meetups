package domain;

/**
 * Created by user on 23/10/2016.
 */
public class VariableOperation implements Operation {
    private String variableName;

    public VariableOperation(String variableName) {
        this.variableName = variableName;
    }

    public NumberOperation interprete(Context context) {
        return context.getValueFor(variableName);
    }

}
