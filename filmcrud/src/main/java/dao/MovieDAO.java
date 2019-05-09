package dao;

import models.Movie;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class MovieDAO implements Dao<Movie> {

    private EntityManager entityManager;

    public MovieDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public Optional<Movie> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Movie> getAll() {
        Query query = entityManager.createQuery("FROM Movie m", Movie.class);
        return query.getResultList();
    }

    @Override
    public void save(Movie movie) {

    }

    @Override
    public void delete(Movie movie) {

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
