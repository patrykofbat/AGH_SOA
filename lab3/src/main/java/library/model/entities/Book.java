package library.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    private Integer id;
    private String title;
    private String category;
    private double price;
    private String currency;
    private String pages;

    private BookAuthor author;

    private Set<BookLoan> bookLoans;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }


    @ManyToOne(targetEntity = BookAuthor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_author_id")
    public BookAuthor getAuthor() {
        return author;
    }

    public void setAuthor(BookAuthor author) {
        this.author = author;
    }

    @OneToMany(mappedBy = "book")
    public Set<BookLoan> getBookLoans() {
        return bookLoans;
    }

    public void setBookLoans(Set<BookLoan> bookLoans) {
        this.bookLoans = bookLoans;
    }

    @Override
    public String toString() {
        return this.title + " " + this.category + " " + this.price;
    }

    @Transient
    public String getFullAuthorName() {
        return this.author.getFirstName() + " " + this.author.getLastName();
    }

    public void setFullAuthorName(String name) {
        String[] names = name.split(" ");
        this.author.setFirstName(names[0]);
        this.author.setFirstName(names[1]);
    }
}
