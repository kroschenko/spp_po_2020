package queue;

import org . junit .*; // Импорт всех основных классов и аннотаций JUnit

import java.util.NoSuchElementException;

import static org . junit . Assert .*;

public class QueueTest1 {
    Queue<String> stringQueue;

    @Before
    public void setUpBeforTest () {
        stringQueue = new Queue<String>();
    }

    @After
    public void setUpAfterTest () {

        stringQueue = null;
    }

    @Test
    public void testIsEmpty() {
        assertEquals(true, stringQueue.isEmpty());
    }



    @Test (expected = NoSuchElementException. class )
    public void testPeekNoSuchElementException(){
        stringQueue.peek();
    }

    @Test (expected = NoSuchElementException. class )
    public void testDequeue(){
        stringQueue.dequeue();
    }
}
