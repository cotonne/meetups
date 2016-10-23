package domain;

/**
 * Created by user on 23/10/2016.
 */
public class BusinessSpecification {

    private static AndSpecification the_main_business_rule = new AndSpecification(new UserHasValidNameSpecification(),
            new OrSpecification(new UserHasValidEmailSpecification(), new UserHasValidNumberSpecification()));
    ;

    public static boolean isSatisfiedBy(User user) {
        return the_main_business_rule.isSatisfiedBy(user);
    }
}
