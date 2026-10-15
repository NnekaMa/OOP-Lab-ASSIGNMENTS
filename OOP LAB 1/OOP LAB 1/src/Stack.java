import java.util.ArrayList;
// BEFORE (inheritance): class Stack extends ArrayList<String> {...}
// It wrongly exposes add(index , x ), remove(index), get(i), set(...), clear()
//AFTER  (composition): a Stack HAS-A list
public class Stack {
    private final ArrayList<String> items = new ArrayList<>();  // hidden

    public  void push(String item) {items.add(item);}

    public String pop() {return  items.remove(items.size()  -1);}

    public static void main(String[] args){
        Stack s = new Stack();
        s.push("A");
        s.push("B");
        System.out.println(s.pop());  //B
        System.out.println(s.pop()); //A
        // s.add(0, "X";  // compile error: Stack has no add() method
    }
}
