package Lesson5.Hibernate.repository;

import org.hibernate.Session;
import java.util.List;
import java.util.Optional;

public interface BaseRepository <T, ID> {
    void setSession(Session session);
    T find(T entity);
    T findById(ID id);
    List<T> findAll();
    T save(T entity);
    T update(T entity);
    void delete(T entity);
    void deleteById(ID id);
    Long countAll();
}
