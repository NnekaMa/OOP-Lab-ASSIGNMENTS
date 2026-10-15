import java.util.ArrayList;

// Generic class: T is the type supplied by the caller (Stack8<String>, Stack8<Integer>)
class Stack8<T> {
    private final ArrayList<T> items = new ArrayList<>();   // backing list, hidden from callers

    void push(T item) { items.add(item); }                  // add on top

    T pop() {                                               // remove and return the top
        if (items.isEmpty()) throw new RuntimeException("Stack is empty");
        return items.remove(items.size() - 1);
    }

    T peek() {                                              // look at the top without removing
        if (items.isEmpty()) throw new RuntimeException("Stack is empty");
        return items.get(items.size() - 1);
    }

    boolean isEmpty() { return items.isEmpty(); }
}

class StackTest {
    public static void main(String[] args) {
        Stack8<String> s = new Stack8<>();   // a stack of Strings
        s.push("A");
        s.push("B");
        s.push("C");

        System.out.println("Peek: " + s.peek());      // C
        System.out.println("Pop: " + s.pop());        // C
        System.out.println("Pop: " + s.pop());        // B
        System.out.println("Empty? " + s.isEmpty());  // false

        Stack8<Integer> n = new Stack8<>();  // the same class works for Integers
        n.push(10);
        System.out.println("Integer pop: " + n.pop());   // 10
    }
}