import domain.Expression;
import domain.Value;
import domain.Visitor;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
/**
 * Created by user on 23/10/2016.
 */
public class VisitorTest {
    private Visitor visitor = new Visitor();
    private Expression expression;

    @Test
    public void should_evaluate_a_really_simple_expression() {
        given_an_addition_like_1_added_to_2();
        when_the_expression_is_evaluated();
        then_the_result_should_be(3);
    }

    @Test
    public void should_evaluate_the_expression() {
        given_a_complex_operation_like_1_added_to_2_then_multiply_by_3();
        when_the_expression_is_evaluated();
        then_the_result_should_be(9);
    }

    private void given_a_complex_operation_like_1_added_to_2_then_multiply_by_3() {
        expression = new Expression.Builder().element(1).element(2).add().element(3).multiply().build();
    }

    private void then_the_result_should_be(int expectedResult) {
        assertThat(visitor.getResult()).isEqualTo(new Value(expectedResult));
    }

    private void when_the_expression_is_evaluated() {
        expression.accept(visitor);
    }

    private void given_an_addition_like_1_added_to_2() {
        expression = new Expression.Builder().element(1).element(2).add().build();
    }
}
