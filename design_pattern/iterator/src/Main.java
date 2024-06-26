import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("JAVA 언어로 배우는 디자인 패턴 입문"));
        bookShelf.appendBook(new Book("자바 알고리즘 인터뷰"));
        bookShelf.appendBook(new Book("명품 운영체제"));

        // Iterator 방법
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // 확장 for 문 방법
        // 확장 for 문은 Iterable 인터페이스를 구현한 클래스의 인스턴스에 대해 내부적으로 Iteartor를 사용하여 처리한다.
        // 따라서 확장 for문 배후에서는 Iterator 패턴이 사용된다.
        for (Book book : bookShelf) {
            System.out.println(book.getName());
        }
    }
}