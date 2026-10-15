public class Person4 {
    String name;
    int age;

    Person4(String name, int age){
        this.name=name;
        this.age=age;

    }
    // Inherited by Student, so it is written only once
    void display(){
        System.out.println("Name:"  + name + " , Age: " + age);
    }
}
//extends =  Students IS-A Person
class   Student4 extends Person4{
    String course;

    Student4(String name, int age, String course){
        super(name,age);  // calls the Person constructor; must be the first statement
        this.course=course;
    }
}
class Teacher4 extends Person4{
    String subject;
    Teacher4(String name, int age , String subject){
        super(name,age); // refuses the Person4 constructor
        this.subject=subject;
    }
}

class Person4Demo{
    public static void main(String[] args){
        Teacher4 t  = new Teacher4("Faith" , 40, "JAVA");
        Student4 s = new Student4("Rudo" , 20, "OOP");

        //Both call the SAME display() method which is written once in Person4
        t.display(); // Name:Faith, Age :40
        s.display(); // Name:Rudo, Age: 20(inherited method)
        System.out.println("Course: " + s.course); // Course:OOP
        System.out.println("Subject: "+ t.subject );// Subject:JAVA
    }

}
