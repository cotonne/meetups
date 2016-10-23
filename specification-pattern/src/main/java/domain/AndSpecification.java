package domain;

/**
 * Created by user on 23/10/2016.
 */
public class AndSpecification {
    private Specification leftOperand;
    private Specification rightOperand;

    public AndSpecification(Specification leftOperand, Specification rightOperand) {

        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }
    public boolean isSatisfiedBy(User user) {
        return leftOperand.isSatisfiedBy(user) && rightOperand.isSatisfiedBy(user);
    }
}
