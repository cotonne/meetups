package domain;

import java.util.Stack;
import java.util.function.Function;

/**
 * Created by user on 23/10/2016.
 */
public abstract class Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public Expression(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    protected Expression() {

    }

    public void accept(Visitor visitor) {
        leftOperand.accept(visitor);
        rightOperand.accept(visitor);
        visitor.visit(this);
    }

    public abstract Function<Value, Value> apply(Value leftOperand);

    public static class Builder {
        private Stack<Expression> expressions = new Stack<Expression>();

        public Builder element(int e) {
            expressions.push(new Value(e));
            return this;
        }

        public Builder add() {
            Expression rightOperand = expressions.pop();
            Expression leftOperand = expressions.pop();
            expressions.push(new AddExpression(leftOperand, rightOperand));
            return this;
        }

        public Builder multiply() {
            Expression rightOperand = expressions.pop();
            Expression leftOperand = expressions.pop();
            expressions.push(new MultiplyExpression(leftOperand, rightOperand));
            return this;
        }

        public Expression build() {
            return expressions.pop();
        }
    }
}
