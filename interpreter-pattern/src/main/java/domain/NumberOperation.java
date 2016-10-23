package domain;

/**
 * Created by yvan on 19/10/16.
 */
public class NumberOperation implements Operation {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberOperation that = (NumberOperation) o;

        return value == that.value;

    }

    @Override
    public int hashCode() {
        return value;
    }

    public int getValue() {
        return value;
    }

    private final int value;

    public NumberOperation(int i) {
        this.value = i;
    }

    public NumberOperation interprete(Context context) {
        return this;
    }
}
