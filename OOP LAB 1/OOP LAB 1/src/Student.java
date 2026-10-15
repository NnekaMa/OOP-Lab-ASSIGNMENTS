public class Student {
    //private:outside code cannot touch these directly
    private String name;
    private int marks;
     // The constructor goes through the setter, so the same validation applies
    public Student(String name, int marks){
        this.name=name;
        setMarks(marks);
    }
    public String getName(){
        return name;
    }

    public int getMarks() {
        return marks;

    }
    //Return the grade calculated from the marks.
    //There is no grade field: it is worked out each time, so it can never be out of date.
    public  char getGrade(){
        if (marks >= 80 ){
            return 'A';
        }else if (marks >= 70){
            return 'B';
        }else if (marks >= 50){
            return 'C';
        }else{
            return'F';
        }
    }
    // Setter with validation: reject marks outside 0 to 100
    public void setMarks(int marks){
        if (marks <0 || marks >100){
            throw new IllegalArgumentException("Marks must be between 0 to 100, got:" + marks );
        }
        this.marks=marks;
    }
    public static void main(String[] args){
        Student s= new Student("Faith" ,75);
        System.out.println(s.getName() + " has " + s.getMarks()+ "  marks"); // Faith has 75 marks

        s.setMarks(90); // valid, accepted
        System.out.println("Updated marks:  "  + s.getMarks());

        System.out.println("Grade: " + s.getGrade()); // marks are 90 , so A
        s.setMarks(65);
        System.out.println("Grade: " + s.getGrade()); // C
        s.setMarks(30);
        System.out.println("Grade: " + s.getGrade()); //F

        try {
            s.setMarks(150);// invalid, rejected
        }catch (IllegalArgumentException e){
            System.out.println("Rejected:   " + e.getMessage());
        }
        System.out.println("Marks are still:  " + s.getMarks());
    }
}
