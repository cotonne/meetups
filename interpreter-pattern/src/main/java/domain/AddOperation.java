package domain;

/**
 * Created by yvan on 19/10/16.
 */
public class AddOperation implements Operation {
    private Operation leftOperand;
    private Operation rightOperand;

    public AddOperation(Operation leftOperand, Operation rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public NumberOperation interprete(Context context) {
        NumberOperation evaluatedLeftOperation = leftOperand.interprete(context);
        NumberOperation evaluatedRightOperation = rightOperand.interprete(context);
        return new NumberOperation(evaluatedLeftOperation.getValue() + evaluatedRightOperation.getValue());
    }
}
