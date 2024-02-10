package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			bookRepository.save(new Book(0, "Salamurhaajan oppipoika", "Robin Hobb", 1996, "978-951-1-32821-61", 18.50));
			bookRepository.save(new Book(0, "Näkymättömät naiset", "Caroline Criado Perez", 2020, "978-951-0-4466-52", 24.90));

		};
	}
}
