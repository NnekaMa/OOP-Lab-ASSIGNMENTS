
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class DuplicatesDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Asha", "Rudo", "Asha", "Faith", "Rudo"));
        System.out.println("With duplicates: " + names);

        // A Set cannot hold duplicates; LinkedHashSet also keeps the original order
        Set<String> unique = new LinkedHashSet<>(names);

        // Copy back into a list if you need a List again
        names = new ArrayList<>(unique);
        System.out.println("Without duplicates: " + names);
    }
}
