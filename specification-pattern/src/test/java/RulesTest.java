import domain.User;
import domain.UserHasValidEmailSpecification;
import domain.UserHasValidNameSpecification;
import domain.UserHasValidNumberSpecification;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by user on 23/10/2016.
 */
public class RulesTest {
    @Test
    public void should_indicate_that_the_user_has_a_valid_email() {
        final User validUserWithEmail = new User("Bob", "", "bob@aol.com");
        boolean isValid = new UserHasValidEmailSpecification().isSatisfiedBy(validUserWithEmail);
        assertThat(isValid).isEqualTo(true);
    }

    @Test
    public void should_indicate_that_the_user_has_an_invalid_email() {
        final User invalidUser = new User("George", "", "");
        boolean isValid = new UserHasValidEmailSpecification().isSatisfiedBy(invalidUser);
        assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void should_indicate_that_the_user_has_a_valid_number() {
        final User validUserWithMobile = new User("Bob", "23654", "");
        boolean isValid = new UserHasValidNumberSpecification().isSatisfiedBy(validUserWithMobile);
        assertThat(isValid).isEqualTo(true);
    }

    @Test
    public void should_indicate_that_the_user_has_an_invalid_number() {
        final User invalidUser = new User("George", "", "");
        boolean isValid = new UserHasValidNumberSpecification().isSatisfiedBy(invalidUser);
        assertThat(isValid).isEqualTo(false);
    }

    @Test
    public void should_indicate_that_the_user_has_a_valid_name() {
        final User validUser = new User("Bob", "23654", "");
        boolean isValid = new UserHasValidNameSpecification().isSatisfiedBy(validUser);
        assertThat(isValid).isEqualTo(true);
    }

    @Test
    public void should_indicate_that_the_user_has_an_invalid_name() {
        final User invalidUser = new User("", "", "");
        boolean isValid = new UserHasValidNameSpecification().isSatisfiedBy(invalidUser);
        assertThat(isValid).isEqualTo(false);
    }

}
