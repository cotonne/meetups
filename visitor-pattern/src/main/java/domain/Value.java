package domain;

import java.util.function.Function;

/**
 * Created by user on 23/10/2016.
 */
public class Value extends Expression {
    private int value;

    public Value(int value) {
        super();
        this.value = value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Value add(Value x) {
        return new Value(value + x.value);
    }

    public Value multiply(Value x) {
        return new Value(value * x.value);
    }

    public Function<Value, Value> apply(Value leftOperandValue) {
        return x -> this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Value value1 = (Value) o;

        return value == value1.value;

    }

    @Override
    public int hashCode() {
        return value;
    }
}
