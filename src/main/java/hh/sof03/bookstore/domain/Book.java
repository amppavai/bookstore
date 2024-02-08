package hh.sof03.bookstore.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid")
    private Integer id;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private double price;

    public Book() {
        super();
        this.id = 0;
        this.title = "";
        this.author = "";
        this.publicationYear = 0;
        this.isbn = "";
        this.price = 0.0;
    }

    public Book(Integer id, String title, String author, int publicationYear, String isbn, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    // getterit ja setterit: right click > source action > generate getters/setters
    
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", price=" + price + "]";
        // return "Book [title:" + title + ", \nauthor:" + author + ",
        // \npublicationYear:" + publicationYear + ", \nisbn:" + isbn + ", \nprice:" +
        // price + "]";
    }
}
