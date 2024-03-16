package hh.sof03.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("Save some categories");
			Category scifi = categoryRepository.save(new Category("Scifi"));
			Category fiction = categoryRepository.save(new Category("Fiction"));
			Category research = categoryRepository.save(new Category("Research"));

			log.info("Save some sample books");
			bookRepository.save(new Book(0, "Salamurhaajan oppipoika", "Robin Hobb", 1996, "97895113282161", 18.55, fiction));
			bookRepository.save(new Book(0, "Näkymättömät naiset", "Caroline Criado Perez", 2020, "9789510446652", 24.99, research));
			bookRepository.save(new Book(0, "Vanhus ja meri", "Ernest Hemingway", 1952, "9789513180072", 18.99, fiction));
			bookRepository.save(new Book(0, "Dune", "Frank Herbert", 2015, "9780340960196", 14.30, scifi));
			bookRepository.save(new Book(0, "Vuonna 1984", "George Orwell", 1949, "9789510404478", 11.25, fiction));


			log.info("Fetch all the categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

			log.info("Fetch all the books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
