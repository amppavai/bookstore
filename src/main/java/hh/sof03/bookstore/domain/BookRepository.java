package hh.sof03.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByAuthorIgnoreCase(String author);
    List<Book> findByAuthorOrderByAuthorAsc(String author);
    @SuppressWarnings("null")
    Iterable<Book> findAll();
    Optional<Book> findById(@SuppressWarnings("null") Integer id);
}