import java.util.List;
import java.util.stream.Collectors;

// record: immutable data carrier. Named StudentRecord to avoid clashing with your other Student classes.
record StudentRecord(String name, double marks) { }

class StreamDemo {
    public static void main(String[] args) {
        List<StudentRecord> students = List.of(
                new StudentRecord("Asha", 80),
                new StudentRecord("Rudo", 85),
                new StudentRecord("Faith", 60),
                new StudentRecord("Brian", 90),
                new StudentRecord("Chipo", 55)
        );

        // Class average: stream the marks and take the average
        double average = students.stream()
                .mapToDouble(StudentRecord::marks)
                .average()
                .orElse(0);
        System.out.println("Class average: " + average);

        // Names above the average, sorted alphabetically
        List<String> aboveAverage = students.stream()
                .filter(s -> s.marks() > average)      // keep students above the average
                .map(StudentRecord::name)              // take just the names
                .sorted()                              // alphabetical order
                .collect(Collectors.toList());         // gather the result into a list

        System.out.println("Above average: " + aboveAverage);
    }
}
