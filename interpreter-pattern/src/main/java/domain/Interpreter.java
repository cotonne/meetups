package domain;

/**
 * Created by yvan on 19/10/16.
 */
public class Interpreter {
    public NumberOperation interprete(Operation ast, Context context) {
        return ast.interprete(context);
    }
}
