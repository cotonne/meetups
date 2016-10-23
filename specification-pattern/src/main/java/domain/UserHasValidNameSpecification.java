package domain;

/**
 * Created by user on 23/10/2016.
 */
public class UserHasValidNameSpecification implements Specification{
    @Override
    public boolean isSatisfiedBy(User user) {
        return !user.getName().isEmpty();
    }
}
