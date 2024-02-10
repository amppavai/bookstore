package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookstoreController {

    @Autowired
    private BookRepository bookRepository;

    // etu-/aloitussivu
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getBooks(Model model) {
        /*
         * List<Book> books = new ArrayList<>();
         * 
         * books.add(new Book(0, "Kirja 1", "Ernest Hemingway", 1929, "vc5y45uv236",
         * 10));
         * books.add(new Book(1, "Kirja 2", "George Orwell", 1945, "72cb64i7", 15));
         */
        model.addAttribute("books", bookRepository.findAll());
        return "index"; // index.html
    }

    // kirjojen listaus
    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String listBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; // booklist.html
    }

    // lisää uusi kirja
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook"; // addbook.html
    }

    // uuden kirjan tallentaminen
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }
    //kirjan poistaminen listasta
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id")Integer bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:booklist";
    }
}
