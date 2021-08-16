package Lesson5.Hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public interface BaseRepository <T, ID> {
    T findById(ID id);
    List<T> findAll();
//    T save(T entity);
//    T update(T entity);
    T merge(T entity);
    boolean delete(T entity);
    boolean deleteById(ID id);
}
