package queue;

import org . junit .*; // Импорт всех основных классов и аннотаций JUnit

import java.util.NoSuchElementException;

import static org . junit . Assert .*;

public class QueueTest2 {
    Queue<String> stringQueue;

    @Before
    public void setUpBeforTest () {
        stringQueue = new Queue<String>();
        stringQueue.enqueue("AAA");
    }

    @After
    public void setUpAfterTest () {

        stringQueue = null;
    }

    @Test
    public void testPeek() {
        assertEquals("AAA", stringQueue.peek());
    }

    @Test
    public void testEnqueue() {
        assertEquals("AAA", stringQueue.peek());
    }
}
