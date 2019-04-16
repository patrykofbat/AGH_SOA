package library.services;

import library.dao.BookDao;
import library.dao.BookLoanDao;
import library.model.entities.BookLoan;

import java.util.List;

public class BookLoanService {

    private BookLoanDao bookLoanDao;

    public BookLoanService() {
        this.bookLoanDao = new BookLoanDao();
    }

    public List<BookLoan> getAllBooksLoans() {
        return bookLoanDao.getAll();
    }

    public List<BookLoan> findAllByReaderId(int readerId) {
        return this.bookLoanDao.findAllByReaderId(readerId);
    }

    public void update(BookLoan bookLoan) {
        this.bookLoanDao.update(bookLoan);
    }

    public void delete(BookLoan bookLoan) {
        this.bookLoanDao.delete(bookLoan);
    }

    public List<BookLoan> findAll(BookLoan bookLoan) {
        return this.bookLoanDao.findAll(bookLoan);
    }

}
