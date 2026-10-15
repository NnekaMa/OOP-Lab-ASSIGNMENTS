public class Animal4 {
    String name;
    // Only a constructor with a parameter: Java does NOT create a default one
    Animal4(String name){
        this.name=name;
    }
}
// FAILS TO COMPILE:
// class Dod4 extends Animal4{
//  Dod4() // Java inserts super() automatically, nut Animal4 has no
//}            //no-argument constructor -> compile error
// FIX: call the Animal4 constructor yourself with super(name)
class  Dog4 extends Animal4{
    Dog4(String name ){
        super(name);  // must be the first statement
    }
}
class AnimalDemo{
    public static void main(String[] args){
        Dog4 d  = new Dog4("Rex");
        System.out.println("Dog name: " + d.name ); // Dog name: Rex
    }
}


