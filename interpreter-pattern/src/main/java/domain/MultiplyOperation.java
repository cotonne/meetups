package domain;


/**
 * Created by yvan on 19/10/16.
 */
public class MultiplyOperation implements Operation {
    private Operation leftOperand;
    private Operation rightOperand;

    public MultiplyOperation(Operation leftOperand, Operation rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public NumberOperation interprete() {
        NumberOperation evaluatedLeftOperation = leftOperand.interprete();
        NumberOperation evaluatedRightOperation = rightOperand.interprete();
        return new NumberOperation(evaluatedLeftOperation.getValue() * evaluatedRightOperation.getValue());
    }
}
