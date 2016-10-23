package domain;

/**
 * Created by user on 23/10/2016.
 */
public class OrSpecification implements Specification {
    private Specification leftOperand;
    private Specification rightOperand;

    public OrSpecification(Specification leftOperand, Specification rightOperand) {

        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return leftOperand.isSatisfiedBy(user) || rightOperand.isSatisfiedBy(user);
    }
}
