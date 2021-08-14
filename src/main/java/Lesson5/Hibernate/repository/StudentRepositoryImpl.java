package Lesson5.Hibernate.repository;

import Lesson5.Hibernate.model.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private Session session;

    public StudentRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public Student findById(Long id) {
        return session.get(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return session.createQuery("from Student").list();
    }

    @Override
    public Student save(Student entity) {
        session.persist(entity);
        return entity;
    }

    @Override
    public Student update(Student entity) {
        return (Student) session.merge(entity);
    }

    @Override
    public void delete(Student entity) {
        deleteById(entity.getId());
    }

    @Override
    public void deleteById(Long id) {
        session.getNamedQuery("deleteById")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void removeAll() {
        session.createQuery("delete from Student").executeUpdate();
    }

    @Override
    public Long countAll() {
        return (Long) session
                .getNamedQuery("countAll")
                .uniqueResult();
    }

    @Override
    public List<Student> findByName(String name) {
        return session.getNamedQuery("findByName")
                .setParameter("name", name)
                .list();
    }

}