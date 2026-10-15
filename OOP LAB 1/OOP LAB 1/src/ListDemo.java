import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListDemo {
    public static void main(String[] args) {
        // Store 10 integers in an ArrayList (program to the List interface)
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            nums.add(i * 3);   // 3, 6, 9, ... 30
        }

        int sum = 0;
        for (int n : nums) sum += n;                 // sum of all elements
        int max = Collections.max(nums);             // maximum element

        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);

        Collections.reverse(nums);                   // reverse the list in place
        System.out.println("Reversed: " + nums);
    }
}
