interface A {
    default void hello() { System.out.println("Hello from A"); }
}

    interface B {
        default void hello() { System.out.println("Hello from B"); }
    }

    // C inherits two default hello() methods, so the compiler forces it to resolve the conflict
    class C implements A, B {
        @Override
        public void hello() {
            A.super.hello();   // explicitly call A's version
            B.super.hello();   // explicitly call B's version
        }
    }

    class DiamondDemo {
        public static void main(String[] args) {
            new C().hello();
        }
    }

