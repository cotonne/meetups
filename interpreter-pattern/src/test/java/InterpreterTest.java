import domain.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by yvan on 19/10/16.
 */
public class InterpreterTest {

    private Interpreter interpreter;
    private Operation ast;
    private NumberOperation result;
    private Context context;

    @Test
    public void should_compute_correctly_a_simple_operation() {
        given_an_interpreter();
        and_a_simple_operation();
        when_the_interpreter_evaluates_the_operation();
        then_it_should_returns_the_good_result();
    }

    @Test
    public void should_compute_correctly_an_simple_operation_with_variables() {
        given_an_interpreter();
        and_an_operation_which_contains_variables();
        and_a_context_with_values_of_variables();
        when_the_interpreter_evaluates_the_operation();
        then_it_should_returns_the_good_result();
    }

    private void and_a_context_with_values_of_variables() {
        context = new Context(new Value("a", 1), new Value("b", 2), new Value("c", 3));
    }

    private void and_an_operation_which_contains_variables() {
        ast = new MultiplyOperation(new AddOperation(new VariableOperation("a"), new VariableOperation("b")) , new VariableOperation("c") );
    }


    private void then_it_should_returns_the_good_result() {
        assertEquals("(1 + 2) * 3 should be equals to 9", result, new NumberOperation(9));
    }

    private void when_the_interpreter_evaluates_the_operation() {
        result = interpreter.interprete(ast, context);
    }

    private void and_a_simple_operation() {
        ast = new MultiplyOperation(new AddOperation(new NumberOperation(1), new NumberOperation(2)) , new NumberOperation(3) );
    }

    private void given_an_interpreter() {
        interpreter = new Interpreter();
    }

}
