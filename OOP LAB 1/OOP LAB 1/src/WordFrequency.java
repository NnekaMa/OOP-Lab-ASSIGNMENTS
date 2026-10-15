import java.util.*;

class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String text = sc.nextLine().toLowerCase();   // lower case so "The" and "the" match

        // Map: word -> how many times it appears (LinkedHashMap keeps first-seen order for ties)
        Map<String, Integer> freq = new LinkedHashMap<>();
        for (String w : text.split("\\W+")) {        // split on anything that is not a letter or digit
            if (!w.isEmpty()) {
                freq.merge(w, 1, Integer::sum);      // add 1, or start at 1 if the word is new
            }
        }

        // A Map has no sort order, so copy the entries into a list and sort by count, highest first
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
        sc.close();
    }
}
