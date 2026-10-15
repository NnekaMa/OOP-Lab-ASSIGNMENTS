import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

record Learner(String name, double marks) {
    // Grade band worked out from the marks, not stored
    String band() { return marks >= 80 ? "A" : marks >= 60 ? "B" : "C"; }
}

class LearnerReport {
    public static void main(String[] args) {
        try {
            // 1. Load learners from learners.csv (each line looks like: Asha,85)
            List<Learner> learners = Files.lines(Path.of("learners.csv"))
                    .filter(l -> l.contains(","))
                    .map(line -> line.split(","))
                    .map(p -> new Learner(p[0].trim(), Double.parseDouble(p[1].trim())))
                    .collect(Collectors.toList());


            // 2. Group by grade band; TreeMap keeps the bands in order A, B, C
            Map<String, List<Learner>> byBand = learners.stream()
                    .collect(Collectors.groupingBy(Learner::band, TreeMap::new, Collectors.toList()));

            // 3. Write one report file per band
            for (Map.Entry<String, List<Learner>> e : byBand.entrySet()) {
                List<String> lines = e.getValue().stream()
                        .map(l -> l.name() + "," + l.marks())
                        .collect(Collectors.toList());

                Path report = Path.of("band_" + e.getKey() + ".txt");
                Files.write(report, lines);
                System.out.println("Band " + e.getKey() + ": " + lines.size() + " -> " + report);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}