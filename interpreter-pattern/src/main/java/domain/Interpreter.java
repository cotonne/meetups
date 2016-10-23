package domain;

/**
 * Created by yvan on 19/10/16.
 */
public class Interpreter {
    public NumberOperation interprete(Operation ast) {
        return ast.interprete();
    }
}
