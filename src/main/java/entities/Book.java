package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "ISBN", nullable = false, length = 13)
    private String ISBN;

    @Column(name = "title", length = 45)
    private String title;

    @Column(name = "author", length = 45)
    private String author;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Column(name = "publishing_year")
    private Integer publishingYear;

    @Column(name = "publisher", length = 45)
    private String publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Library library;

    @OneToMany(mappedBy = "bookIsbn")
    private Set<Loan> loans = new LinkedHashSet<>();

    public Book() {
    }

    public Book(String ISBN, String title, String author, Integer numberOfPages, Integer publishingYear, String publisher) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.publishingYear = publishingYear;
        this.publisher = publisher;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(Integer publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return ISBN;
    }

    public void setId(String id) {
        this.ISBN = id;
    }

}