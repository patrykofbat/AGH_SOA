package library.dao;

import library.model.entities.BookLoan;
import library.model.entities.Reader;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ReaderDao implements Dao<Reader> {


    private EntityManager entityManager;

    public ReaderDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        this.entityManager = factory.createEntityManager();
    }


    @Override
    public Optional<Reader> get(int id) {
        return Optional.ofNullable(entityManager.find(Reader.class, id));
    }

    @Override
    public List<Reader> getAll() {
        Query query = entityManager.createQuery("FROM Reader e", Reader.class);
        return query.getResultList();
    }

    @Override
    public void save(Reader reader) {
        executeInsideTransaction(entityManager -> entityManager.persist(reader));
    }

    @Override
    public void delete(Reader reader) {
        executeInsideTransaction(entityManager -> entityManager.remove(reader));

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
