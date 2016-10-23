package domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by user on 23/10/2016.
 */
public class UserValidFinder {
    public static Collection<User> select(Collection<User> allUsers) {
        return allUsers.stream().filter(BusinessSpecification::isSatisfiedBy).collect(Collectors.toSet());
    }
}
