package hh.sof03.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@CrossOrigin
@RestController
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    // GET all books
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    // /books/{id}, GET one book by id
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    // POST, add new book
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public @ResponseBody Book addNewBook(@RequestBody Book book) {
        if (book != null) {
            return bookRepository.save(book);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book cannot be null");
        }
    }
}

/*
 * (sain viimeiselle return-riville jatkuvasti virheilmoituksen,
 * kun koodini näytti tältä:
 * 
 * @RequestMapping(value="/books", method = RequestMethod.POST)
 * public @ResponseBody Book addNewBook(@RequestBody Book book) {
 * return bookRepository.save(book);
 * })
 * 
 * Tekoälyn mielipide ja perustelut virheelle:
 * 
 * "Tässä tapauksessa, vaikka oletetaan, että book-olio ei ole null,
 * on mahdollista, että jostain syystä null-olio lähetetään
 * addNewBook-metodille.
 * Tämä voisi johtaa NullPointerException-virheeseen, kun yritetään kutsua
 * save-metodia null-oliolla.
 * Tästä syystä on suositeltavaa lisätä null-tarkistus ennen save-metodin
 * kutsumista,
 * kuten aiemmin ehdotettiin. Tämä varmistaa, että save-metodia ei koskaan
 * kutsuta null-oliolla,
 * mikä auttaa välttämään NullPointerException-virheet.
 * 
 * Tämä ei ole pakollista, mutta se on hyvä ohjelmointikäytäntö,
 * joka auttaa tekemään koodista vakaampaa ja virheidenkestävämpää.""
 */