package dao;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface Dao<T> {

    Optional<T> get(long id);
    List<T> getAll();
    void save(T t);
    void delete(T t);
    void update(T t);


}
