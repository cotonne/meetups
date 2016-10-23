package domain;

import java.util.function.Function;

/**
 * Created by user on 23/10/2016.
 */
public class MultiplyExpression extends Expression {
    public MultiplyExpression(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    public Function<Value, Value> apply(Value leftOperandValue) {
        return x -> leftOperandValue.multiply(x);
    }
}
