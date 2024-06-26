import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book> {

    private List<Book> books;

    BookShelf(int initialCapacity) {
        this.books = new ArrayList<>(initialCapacity);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
