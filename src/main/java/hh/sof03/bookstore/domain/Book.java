package hh.sof03.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

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

    @ManyToOne
    @JsonIgnoreProperties("books")
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
        super();
        this.id = null;
        this.title = "";
        this.author = "";
        this.publicationYear = 0;
        this.isbn = "";
        this.price = 0.0;
        this.category = null;
    }

    public Book(Integer id, String title, String author, int publicationYear, String isbn, double price, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book \ntitle: " + title + ", \nauthor: " + author + ", \npublicationYear: " + publicationYear + ", \nisbn: "
                + isbn + ", \nprice: " + price + ", \ncategory: " + category.getName();
    }
}
