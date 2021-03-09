package live.ilyusha;

public class Stack<Item> {
    private int N;
    private Node first;

    private class Node {
        private Item item;
        private Node next;
    }

    public Stack() {
        first = null;
        N = 0;
        assert check();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
        assert check();
    }

    public Item pop() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty.");
        }
        Item item = first.item;
        first = first.next;
        N--;
        assert check();
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty.");
        }
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node current = first; current != null; current = current.next) {
            Item item = current.item;
            s.append(item + " ");
        }
        return s.toString().replaceFirst("\\s$","");
    }

    private boolean check() {
        int numberOfNodes = 0;
        for (Node x = first; x != null; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != N) {
            return false;
        }

        if (N == 0) {
            return first == null;
        } else if (N == 1) {
            return first != null && first.next == null;
        } else {
            return first.next != null;
        }
    }
}