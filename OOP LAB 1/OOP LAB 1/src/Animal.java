public class Animal {
    void sound() {
        System.out.println("Some animal sound");
    }
}
    class Cat extends Animal {
        @Override
        void sound() {
            System.out.println("Meow");
        }
    }
        class Cow extends Animal {
            @Override
            void sound() {
                System.out.println("Moo");
            }
        }
            class Duck extends Animal {
                @Override
                void sound() {
                    System.out.println("Quack");
                }
            }
        class AnimalTest {
            public static void main(String[] args){
                // Animal[] holds all three subclasses (upcasting)
                Animal[] animals= {new Cat(),  new Cow(), new Duck()};
                // Loop through the array and call sound()  on each
                for(Animal a : animals){
                    a.sound();
                }
            }
        }


