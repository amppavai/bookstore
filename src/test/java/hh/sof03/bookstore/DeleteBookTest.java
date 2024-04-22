package hh.sof03.bookstore;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = BookstoreApplication.class)
public class DeleteBookTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Rollback(false)
    public void deleteBook() {

        Book book = bookRepository.findById(Integer.valueOf(4)).get();

        bookRepository.delete(book);

        Optional<Book> deleteBook = bookRepository.findById(Integer.valueOf(4));

        assertThat(deleteBook).isEmpty();

    }
}
