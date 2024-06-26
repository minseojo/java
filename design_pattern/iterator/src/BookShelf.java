import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book> {

    private List<Book> books = new ArrayList<>();

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public boolean appendBook(Book book) {
        return books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
