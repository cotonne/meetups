package domain;

/**
 * Created by user on 23/10/2016.
 */
public class UserHasValidEmailSpecification implements Specification {
    @Override
    public boolean isSatisfiedBy(User validUserWithEmail) {
        return !validUserWithEmail.getEmail().isEmpty();
    }
}
