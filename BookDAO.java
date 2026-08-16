import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // In a real system, this would query a database.
    // without requiring a live database connection.
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book(1, "Bright Creatures", "Robert C. Martin", "9780132350884", true));
        books.add(new Book(2, "A THousand Lanterns", "Elizabeth Lim", "9780134685991", true));
        books.add(new Book(3, "The DaVinci Code", "Dan Brown", "9780596007126", false));
        books.add(new Book(4, "Friends", "Fredrick Beckman", "9780262033848", true));

        return books;
    }
}