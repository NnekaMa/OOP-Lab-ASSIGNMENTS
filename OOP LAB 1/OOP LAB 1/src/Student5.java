import java.util.Arrays;
import java.util.Comparator;

    class Student6 implements Comparable<Student6> {
        String name;
        int marks;

        Student6(String name, int marks) { this.name = name; this.marks = marks; }

        // Natural ordering: by name (A to Z)
        @Override
        public int compareTo(Student6 other) {
            return this.name.compareTo(other.name);
        }
        public String toString() { return name + "(" + marks + ")"; }
    }

    // Comparator: a separate, extra ordering by marks (highest first)
    class MarksComparator implements Comparator<Student6> {
        @Override
        public int compare(Student6 a, Student6 b) {
            return Integer.compare(b.marks, a.marks);
        }
    }

    class SortDemo {
        public static void main(String[] args) {
            Student6[] students = {
                    new Student6("Rudo", 70), new Student6("Asha", 95), new Student6("Faith", 82)
            };

            Arrays.sort(students);   // uses compareTo (by name)
            System.out.println("By name:  " + Arrays.toString(students));

            Arrays.sort(students, new MarksComparator());   // uses the Comparator
            System.out.println("By marks: " + Arrays.toString(students));
        }
    }

