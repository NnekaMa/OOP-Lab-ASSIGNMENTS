import java.util.Iterator;

// Iterable<T> is what allows the for-each loop on this class
class MyLinkedList<T> implements Iterable<T> {

    // Static nested class: a helper that needs no access to the outer object
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head, tail;

    void add(T value) {                     // add at the end
        Node<T> n = new Node<>(value);
        if (head == null) head = tail = n;
        else { tail.next = n; tail = n; }
    }

    // Inner (non-static) class: it uses the outer object's head field
    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;     // starts at the outer list's head

        @Override public boolean hasNext() { return current != null; }

        @Override public T next() {
            T value = current.data;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() { return new ListIterator(); }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        for (String s : list) {             // works because of the iterator
            System.out.println(s);
        }
    }
}
