import domain.User;
import domain.UserValidFinder;
import domain.Users;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by user on 23/10/2016.
 */
public class UserValidFinderTest {
    @Test
    public void should_only_find_users_with_age_above_20_and_with_a_phone_number_or_with_a_email() {
        given_a_set_of_some_valid_and_invalid_users();
        when_i_select_only_users_which_are_valid();
        then_only_users_with_a_name_and_an_email_or_a_phone_are_selected();
    }

    private void given_a_set_of_some_valid_and_invalid_users() {
        allUsers = Collections.unmodifiableCollection(Arrays.asList(validUserWithEmail, validUserWithMobile, invalidUser));
    }

    private void when_i_select_only_users_which_are_valid() {
        users = UserValidFinder.select(allUsers);
    }

    private void then_only_users_with_a_name_and_an_email_or_a_phone_are_selected() {
        assertThat(users).isEqualTo(new HashSet<>(Arrays.asList(
                validUserWithEmail, validUserWithMobile
        )));
    }

    final User validUserWithEmail = new User("Bob", "", "bob@aol.com");
    final User validUserWithMobile = new User("Bob", "23654", "");
    final User invalidUser = new User("George", "", "");
    private Collection<User> allUsers;
    private Collection<User> users;

}
