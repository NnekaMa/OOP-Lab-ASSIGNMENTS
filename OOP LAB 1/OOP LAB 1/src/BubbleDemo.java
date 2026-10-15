import java.util.Arrays;

class BubbleDemo {
    // Bounded type parameter: T must be Comparable, so compareTo() is guaranteed to exist
    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {   // out of order, so swap
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 9, 1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));    // [1, 2, 5, 9]

        String[] words = {"pear", "apple", "mango"};
        bubbleSort(words);
        System.out.println(Arrays.toString(words));   // [apple, mango, pear]

        // int[] raw = {3, 1, 2};
        // bubbleSort(raw);   // compile error: int[] is not a T[]
    }
}
