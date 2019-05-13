package dao;

import models.Movie;
import models.User;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class UserDAO implements Dao<User> {
    private EntityManager entityManager;

    public UserDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        executeInsideTransaction(entityMng -> entityMng.persist(user));
    }

    @Override
    public void delete(User user) {
        executeInsideTransaction(entityMng -> entityMng.remove(user));
    }

    @Override
    public void update(User user) {
        executeInsideTransaction(entityMng -> entityMng.merge(user));
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
