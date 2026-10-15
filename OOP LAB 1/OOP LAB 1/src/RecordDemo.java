// record: a compact, immutable class. Java generates the constructor,
// accessors name() and age(), equals(), hashCode() and toString().
record StudentRec(String name, int age) { }

class RecordDemo {
    public static void main(String[] args) {
        StudentRec s1 = new StudentRec("Faith", 20);
        StudentRec s2 = new StudentRec("Faith", 20);
        StudentRec s3 = new StudentRec("Rudo", 22);

        System.out.println(s1);                  // print it (generated toString)
        System.out.println(s1.equals(s2));       // compare two equal records: true
        System.out.println(s1.equals(s3));       // different values: false
        System.out.println(s1.name());           // read a component with its accessor
        System.out.println(s1.age());
    }
}
