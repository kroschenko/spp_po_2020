import live.ilyusha.Stack;
import org.junit.Before;
import org.junit.Test;


public class StackErrorsTest {
    private Stack<Integer> stack;

    @Before
    public void prepareStack() {
        stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
    }

    @Test(expected = IllegalStateException.class)
    public void popEmptyFailure() {
        while (true) {
            stack.pop();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void peekEmptyFailure() {
        for (int i = 0; i < 3; i++) {
            stack.pop();
        }
        stack.peek();
    }
}
