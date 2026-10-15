import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book9 {
    String isbn;
    String title;

    Book9(String isbn, String title) { this.isbn = isbn; this.title = title; }

    // equals(Object o), not equals(Book9 b): that would overload instead of override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book9)) return false;
        Book9 other = (Book9) o;
        return isbn.equals(other.isbn);        // two books are equal if the ISBN matches
    }

    // Must be consistent with equals: equal objects need equal hash codes
    @Override
    public int hashCode() { return Objects.hash(isbn); }

    @Override
    public String toString() { return title + " (" + isbn + ")"; }
}

class BookDemo {
    public static void main(String[] args) {
        Set<Book9> books = new HashSet<>();
        System.out.println(books.add(new Book9("111", "Java Basics")));    // true: added
        System.out.println(books.add(new Book9("222", "OOP Concepts")));   // true: added
        System.out.println(books.add(new Book9("111", "Java Basics 2")));  // false: same ISBN, rejected

        System.out.println("Set size: " + books.size());   // 2
        System.out.println(books);
    }
}
