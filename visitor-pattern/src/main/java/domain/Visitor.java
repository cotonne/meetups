package domain;

import java.util.Stack;

/**
 * Created by user on 23/10/2016.
 */
public class Visitor {
    private Stack<Value> values = new Stack<Value>();

    public void visit(Expression expression) {
        Value rightOperand = values.pop();
        Value leftOperand = values.pop();
        Value value = expression.apply(leftOperand).apply(rightOperand);
        values.push(value);
    }

    public void visit(Value value) {
        values.push(value);
    }

    public Value getResult() {
        return values.pop();
    }
}
