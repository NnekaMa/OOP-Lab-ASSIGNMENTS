class ArrayDemo {
    // Method that accesses an array element and catches the exception itself
    static void getElement(int[] arr, int index) {
        try {
            System.out.println("Element at " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: index " + index + " is invalid for an array of length " + arr.length);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        getElement(numbers, 1);    // valid
        getElement(numbers, 5);    // too large: caught
        getElement(numbers, -1);   // negative: caught
    }
}