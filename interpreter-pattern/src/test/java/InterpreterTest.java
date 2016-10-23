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

    @Test
    public void should_compute_correctly_a_simple_operation() {
        given_an_interpreter();
        and_a_simple_operation();
        when_the_interpreter_evaluates_the_operation();
        then_it_should_returns_the_good_result();
    }

    private void then_it_should_returns_the_good_result() {
        assertEquals("(1 + 2) * 3 should be equals to 9", result, new NumberOperation(9));
    }

    private void when_the_interpreter_evaluates_the_operation() {
        result = interpreter.interprete(ast);
    }

    private void and_a_simple_operation() {
        ast = new MultiplyOperation(new AddOperation(new NumberOperation(1), new NumberOperation(2)) , new NumberOperation(3) );
    }

    private void given_an_interpreter() {
        interpreter = new Interpreter();
    }


}
