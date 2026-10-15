public class Person {
    String name;
    Address address;// Person HAS-A Address


    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "Tawanda";
        p1.address = new Address();
        p1.address.city = "Masvingo";

        // Chained dot expression:
        System.out.println(p1.address.city);//Works:prints Masvingo

        Person p2 = new Person();
        p2.name = "Faith";
        p2.address = null;  // No  address set

        // This will CRASH
        //System.out.println(p2.address.city);
        //->NullPointerException: Cannot read field "city" because "p2

    }
}

