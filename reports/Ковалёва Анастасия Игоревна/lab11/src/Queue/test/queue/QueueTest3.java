package queue;

import org . junit .*; // Импорт всех основных классов и аннотаций JUnit

import java.util.NoSuchElementException;

import static org . junit . Assert .*;

public class QueueTest3 {
    Queue<String> stringQueue;

    @Before
    public void setUpBeforTest () {
        stringQueue = new Queue<String>();
        stringQueue.enqueue("AAA");
        stringQueue.enqueue("AAA");
        stringQueue.enqueue("AAA");
    }

    @After
    public void setUpAfterTest () {

        stringQueue = null;
    }

    @Test
    public void testSize() {
        assertEquals(3, stringQueue.size());
    }

    @Test
    public void testToString() {
        assertEquals("AAA AAA AAA ", stringQueue.toString());
    }
}
