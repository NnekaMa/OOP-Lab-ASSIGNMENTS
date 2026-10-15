class FinallyDemo {
    static int test() {
        try {
            System.out.println("In try");
            return 1;                        // return is prepared here...
        } finally {
            System.out.println("In finally"); // ...but finally runs BEFORE the method returns
        }
    }

    public static void main(String[] args) {
        int result = test();
        System.out.println("Returned: " + result);
    }
}
