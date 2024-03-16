package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.PathVariable;
/* import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; */
import org.springframework.web.bind.annotation.*;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

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
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook"; // addbook.html
    }

    // uuden kirjan tallentaminen
    @SuppressWarnings("null")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book, @RequestParam(required = false) String newCategory) {
        if (newCategory != null && !newCategory.isEmpty()) {
            Category category = new Category(newCategory);
            categoryRepository.save(category);
            book.setCategory(category);
        }
        bookRepository.save(book);
        return "redirect:booklist";
    }

    /*
     * @RequestMapping(value = "/save", method = RequestMethod.POST)
     * public String saveBook(Book book) {
     * bookRepository.save(book);
     * return "redirect:/booklist";
     * }
     */
    // kirjan poistaminen listasta
    @SuppressWarnings("null")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Integer id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:../booklist";
    }

    // kirjan muokkaaminen
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        return "editbook"; // editbook.html

    }
}
