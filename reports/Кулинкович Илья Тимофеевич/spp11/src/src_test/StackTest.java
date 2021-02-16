import live.ilyusha.Stack;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StackTest {
    private Stack<Integer> stack;

    @Before
    public void prepareStack() {
        stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
    }

    @Test
    public void isEmptyCorrect() {
        assertFalse(stack.isEmpty());
    }

    @Test
    public void sizeCorrectValue() {
        assertEquals(3, stack.size());
    }

    @Test
    public void pushIncreasesSize() {
        stack.push(40);
        assertEquals(4, stack.size());
    }

    @Test
    public void popDecreasesSize() {
        stack.pop();
        assertEquals(2, stack.size());
    }

    @Test
    public void peekMaintainsSize() {
        stack.peek();
        assertEquals(3, stack.size());
    }

    @Test
    public void peekCorrectValue() {
        assertEquals(new Integer(30), stack.peek());
    }

    @Test
    public void toStringCorrectValue() {
        assertEquals("30 20 10", stack.toString());
    }
}
