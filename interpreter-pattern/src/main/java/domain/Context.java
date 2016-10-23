package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 23/10/2016.
 */
public class Context {
    private Map<String, NumberOperation> values = new HashMap<String, NumberOperation>();

    public Context(Value ... values) {
        for(Value v: values) {
            this.values.put(v.getVariableName(), new NumberOperation(v.getValue()));
        }
    }

    public NumberOperation getValueFor(String variableName) {
        return values.get(variableName);
    }

}
