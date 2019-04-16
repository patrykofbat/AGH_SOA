package library.dao;

import library.model.entities.Book;
import library.model.entities.BookLoan;
import library.model.entities.Reader;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class BookLoanDao implements Dao<BookLoan> {

    private EntityManager entityManager;

    public BookLoanDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        this.entityManager = factory.createEntityManager();
    }


    @Override
    public Optional<BookLoan> get(int id) {
        return Optional.ofNullable(entityManager.find(BookLoan.class, id));
    }

    @Override
    public List<BookLoan> getAll() {
        Query query = entityManager.createQuery("FROM BookLoan e", BookLoan.class);
        return query.getResultList();
    }

    @Override
    public void save(BookLoan book) {
        executeInsideTransaction(entityManager -> entityManager.persist(book));
    }

    @Override
    public void delete(BookLoan book) {
        executeInsideTransaction(entityManager -> entityManager.remove(book));
    }

    public void update(BookLoan bookLoan) {
        executeInsideTransaction(entityManager -> entityManager.merge(bookLoan));
    }

    public List<BookLoan> findAllByReaderId(int readerId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookLoan> query = criteriaBuilder.createQuery(BookLoan.class);
        Root<BookLoan> bl = query.from(BookLoan.class);
        query.select(bl)
                .where(criteriaBuilder.equal(bl.get("reader").get("id"), readerId));

        return this.entityManager.createQuery(query).getResultList();
    }

    public List<BookLoan> findAll(BookLoan bookLoan) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookLoan> query = criteriaBuilder.createQuery(BookLoan.class);
        Root<BookLoan> bl = query.from(BookLoan.class);
        query.select(bl)
                .where(criteriaBuilder.equal(bl.get("reader").get("id"), bookLoan.getReader().getId()),
                        criteriaBuilder.like(bl.get("book").get("title"), "%" + bookLoan.getBook().getTitle() + "%")
                        );

        return this.entityManager.createQuery(query).getResultList();
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
