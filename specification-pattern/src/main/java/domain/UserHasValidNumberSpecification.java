package domain;

/**
 * Created by user on 23/10/2016.
 */
public class UserHasValidNumberSpecification implements Specification{
    @Override
    public boolean isSatisfiedBy(User user) {
        return !user.getPhoneNumber().isEmpty();
    }
}
