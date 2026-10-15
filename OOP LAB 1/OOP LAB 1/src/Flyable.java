// Interface: a contract of capabilities. Methods are public by default.
    interface Flyable {
        void fly();
    }

    // Bird and Aeroplane share no superclass, but both can fly
    class Bird implements Flyable {
        @Override
        public void fly() { System.out.println("Bird flaps its wings"); }   // must be public
    }

    class Aeroplane implements Flyable {
        @Override
        public void fly() { System.out.println("Aeroplane uses its engines"); }
    }

    class FlyDemo {
        public static void main(String[] args) {
            // Program to the interface: the array type is Flyable, not Bird or Aeroplane
            Flyable[] things = { new Bird(), new Aeroplane() };

            for (Flyable f : things)
                f.fly();   // each object runs its own fly()
        }
    }

