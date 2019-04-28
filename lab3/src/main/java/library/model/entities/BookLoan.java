package library.model.entities;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "books_loans")
public class BookLoan {

    private int id;
    private Date loanDate;
    private Date returnDate;
    private Reader reader;
    private Book book;
    private transient boolean canEdit = false;

    public BookLoan() {
        this.book = new Book();
        this.reader= new Reader();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "loan_date")
    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {

        this.loanDate = loanDate;
    }

    @Column(name = "return_date")
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @ManyToOne
    @JoinColumn(name = "reader_id")
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @ManyToOne
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }
}
