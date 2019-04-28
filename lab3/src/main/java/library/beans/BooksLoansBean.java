package library.beans;


import library.dao.BookLoanDao;
import library.model.entities.Book;
import library.model.entities.BookLoan;
import library.model.entities.Reader;
import library.services.BookLoanService;
import library.services.ReaderService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.Date;
import java.util.List;

@ViewScoped
@ManagedBean(name = "booksLoans")
public class BooksLoansBean {

    private BookLoanService bookLoanService;
    private ReaderService readerService;
    private List<BookLoan> bookLoansList;
    private BookLoan bookLoanFilters;
    private final int defaultReaderId = 2;
    private Reader currentReader;

    public BooksLoansBean() {
        this.bookLoanService = BookLoanService.getInstance();
        this.readerService = new ReaderService();
        this.bookLoanFilters = new BookLoan();
        this.bookLoanFilters.getReader().setId(this.defaultReaderId);
        this.bookLoansList = this.bookLoanService.findAllByReaderId(this.bookLoanFilters.getReader().getId());
    }

    public BookLoan getBookLoanFilters() {
        return bookLoanFilters;
    }

    public void setBookLoanFilters(BookLoan bookLoanFilters) {
        this.bookLoanFilters = bookLoanFilters;
    }

    public List<BookLoan> getBookLoansList() {
        return bookLoansList;
    }

    public void setBookLoansList(List<BookLoan> bookLoansList) {
        this.bookLoansList = bookLoansList;
    }


    public List<Reader> getAllReaders() {
        return this.readerService.getAllReaders();
    }

    public void changedReader() {
        this.bookLoansList = this.bookLoanService.findAllByReaderId(this.bookLoanFilters.getReader().getId());
    }

    public void delete(BookLoan bookLoan) {
        this.bookLoanService.delete(bookLoan);
        this.bookLoansList = this.bookLoanService.findAllByReaderId(this.bookLoanFilters.getReader().getId());
    }

    public void edit(BookLoan bookLoan) {
        System.out.println(bookLoan.getBook().getTitle());
        if (bookLoan.isCanEdit()) {
            this.bookLoanService.update(bookLoan);
            bookLoan.setCanEdit(false);
        } else {
            bookLoan.setCanEdit(true);
        }

    }

    public void filter() {
        this.bookLoansList = this.bookLoanService.findAll(bookLoanFilters);
    }

    public int getCurrentReaderId() {
        return this.bookLoanFilters.getReader().getId();
    }

    public void setCurrentReaderId(int currentReaderId) {
        this.bookLoanFilters.getReader().setId(currentReaderId);
    }

    public Reader getCurrentReader() {
        Reader reader = new Reader();
        reader.setId(this.defaultReaderId);
        return this.readerService.getReader(this.getCurrentReaderId()).orElse(reader);
    }

    public void loanBook(Book book) {
        System.out.println(book.toString());
        BookLoan bookLoan = new BookLoan();
        bookLoan.setReader(this.getCurrentReader());
        bookLoan.setBook(book);
        bookLoan.setLoanDate(new Date());
        this.bookLoanService.save(bookLoan);
    }
}
