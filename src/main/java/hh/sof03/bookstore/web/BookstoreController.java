package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@Controller
public class BookstoreController {

    @Autowired
    private BookRepository bookRepository;

    //etu-/aloitussivu
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getBooks(Model model) {
        /*List<Book> books = new ArrayList<>();
        
         * books.add(new Book(0, "Kirja 1", "Ernest Hemingway", 1929, "vc5y45uv236",
         * 10));
         * books.add(new Book(1, "Kirja 2", "George Orwell", 1945, "72cb64i7", 15));
         */
        model.addAttribute("books", bookRepository.findAll());
        return "index"; //index.html
    }
    //kirjojen listaus
    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String listBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; //booklist.html
    }

}

/*
 * 5. Bookstore
 * We will now start to create our training project. This excercise continues
 * through the whole course
 * and it will be returned to Github.
 * a.) Create a project called Bookstore by using Spring Initializr page
 * (include web, devtools,
 * thymeleaf)
 * b.) Add a new controller called BookController which handle get request to
 * the path /index
 * c.) Add a new model class called Book which contains attributes: title,
 * author, publicationYear,
 * isbn, price
 * d.) Add your project to your GitHub account (See the instructions from the
 * moodle)
 * Follow the recommended Spring Boot project structure
 */
