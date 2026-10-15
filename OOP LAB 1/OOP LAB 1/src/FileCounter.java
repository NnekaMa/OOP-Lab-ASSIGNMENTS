import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class FileCounter {
    public static void main(String[] args) {
        Path file = Path.of("notes.txt");   // the file from Question 1 (in the project folder)

        try {
            List<String> lines = Files.readAllLines(file);

            int words = 0, chars = 0;
            for (String line : lines) {
                chars += line.length();                        // characters (newlines not counted)
                if (!line.isBlank()) {
                    words += line.trim().split("\\s+").length; // split on any run of spaces
                }
            }

            System.out.println("Lines: " + lines.size());
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());   // e.g. file not found
        }
    }
}
