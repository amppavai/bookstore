package hh.sof03.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.lang.NonNull;

public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByAuthorIgnoreCase(String author);
    List<Book> findByAuthorOrderByAuthorAsc(String author);
    @NonNull
    List<Book> findAll();
    Optional<Book> findById(@NonNull Integer id);
}