package dao;

import models.Movie;
import models.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public Optional<Movie> get(long id) {
        return Optional.ofNullable(entityManager.find(Movie.class, id));
    }

    @Override
    public List<Movie> getAll() {
        Query query = entityManager.createQuery("FROM Movie m", Movie.class);
        return query.getResultList();
    }

    @Override
    public void save(Movie movie) {
        executeInsideTransaction(entityMng -> entityMng.persist(movie));
    }

    @Override
    public void delete(Movie movie) {
        executeInsideTransaction(entityMng -> entityMng.remove(movie));
    }

    @Override
    public void update(Movie movie) {
        executeInsideTransaction(entityMng -> entityMng.merge(movie));
    }

    public List<Movie> findAllByTitle(String title) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> query = criteriaBuilder.createQuery(Movie.class);
        Root<Movie> movieRoot = query.from(Movie.class);
        query.select(movieRoot)
                .where(criteriaBuilder.equal(movieRoot.get("title"), title));

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
