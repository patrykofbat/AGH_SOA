package library.dao;

import library.pojo.Book;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class BookDao implements Dao<Book> {

    private EntityManager entityManager;

    public BookDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        this.entityManager = factory.createEntityManager();
    }


    @Override
    public Optional<Book> get(int id) {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    @Override
    public List<Book> getAll() {
        Query query = entityManager.createQuery("FROM Book e", Book.class);
        return query.getResultList();
    }

    @Override
    public void save(Book book) {
//        this.entityManager.getTransaction().begin();
//        this.entityManager.createNativeQuery("INSERT INTO books (author, category, currency, pages, price, publisher, title) VALUES (?, ?, ?, ?, ?, ?, ?)")
//                .setParameter(1, book.getAuthor())
//                .setParameter(2, book.getCategory())
//                .setParameter(3, book.getCurrency())
//                .setParameter(4, book.getPages())
//                .setParameter(5, book.getPrice())
//                .setParameter(6, book.getPublisher())
//                .setParameter(7, book.getTitle())
//                .executeUpdate();
//        this.entityManager.getTransaction().commit();
        executeInsideTransaction(entityManager -> entityManager.persist(book));
    }

    @Override
    public void delete(Book book) {
        executeInsideTransaction(entityManager -> entityManager.remove(book));

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
