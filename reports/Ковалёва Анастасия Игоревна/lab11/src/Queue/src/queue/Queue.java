package queue;

import java.util.NoSuchElementException;

/**
 * The <tt>Queue</tt> class represents a first-in-first-out (FIFO) queue of
 * generic items. It supports the usual <em>enqueue</em> and <em>dequeue</em>
 * operations, along with methods for peeking at the top item, testing if the
 * queue is empty, and iterating through the items in FIFO order.
 */
// TODO FIXME Find Bugs & Write Tests
public class Queue<Item> {
    private int N; // number of elements on queue
    private Node first; // beginning of queue
    private Node last; // end of queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Create an empty queue.
     */
    public Queue() {
        first = null;
        last = null;
        N = 0;
        assert check();
    }

    /**
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return first == null;   // was return first != null;
    }

    /**
     * Return the number of items in the queue.
     */
    public int size() {
        return N;
    }

    /**
     * Return the item least recently added to the queue.
     *
     * @throws java.util.NoSuchElementException if queue is empty.
     */
    public Item peek() {
        // FIXME throw exception if queue is Empty.
        // TODO implement method
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        return first.item;
    }

    /**
     * Add the item to the queue.
     */
    public void enqueue(Item item) {

        Node oldlast = last;
        ++N;
        last = new Node();
        last.item = item;
        last.next = null;


        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }

        assert check();
    }

    /**
     * Remove and return the item on the queue least recently added.
     *
     * @throws java.util.NoSuchElementException if queue is empty.
     * @return
     */
    public Item dequeue() {
        // FIXME throw exception if queue is Empty.
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        --N;
        if (isEmpty()) {
            last = null; // to avoid loitering

        }
        assert check();
        return item;
    }

    /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node x = first; x != null; x = x.next) {
            s.append(x.item + " ");
        }

        return s.toString();
    }

    // check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null) {
                return false;
            }
            if (last != null) {
                return false;
            }
        } else if (N == 1) {
            if (first == null || last == null) {
                return false;
            }
            if (first != last) {
                return false;
            }
            if (first.next != null) {
                return false;
            }
        } else {
            if (first == last) {
                System.out.println((first == last) + "first == last");
                return false;
            }
            if (first.next == null) {
                return false;
            }
            if (last.next != null) {
                return false;
            }

            // check internal consistency of instance variable N
            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next) {
                numberOfNodes++;
            }
            if (numberOfNodes != N) {
                return false;
            }
            // check internal consistency of instance variable last
            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            if (last != lastNode) {
                return false;
            }
        }

        return true;
    }
}
