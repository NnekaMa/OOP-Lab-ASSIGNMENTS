import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class RemoveEvenDemo {
    public static void main(String[] args) {
        // ArrayList, because List.of(...) is immutable and removeIf would fail on it
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println("Before: " + nums);

        // Predicate: a functional interface whose test() returns true or false
        Predicate<Integer> isEven = n -> n % 2 == 0;

        nums.removeIf(isEven);   // removes every element for which the predicate is true
        System.out.println("After:  " + nums);
    }
}
