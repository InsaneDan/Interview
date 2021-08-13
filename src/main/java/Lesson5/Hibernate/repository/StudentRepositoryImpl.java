package Lesson5.Hibernate.repository;

import Lesson5.Hibernate.model.Student;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Student find(Student entity) {
        return null;
    }

    @Override
    public Student findById(Long id) {
        return session.get(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return null;
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

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Long countAll() {
        return null;
    }








    @Override
    public Student find(Student entity) {
        return null;
    }







    @Override
    public List<Student> findAll() {
        return (List<Student>) session.createQuery("from Student").list();
    }

    @Override
    public void deleteById(Long id) {
        session.createQuery("delete from Student s where s.id = :id").setLong("id", id).executeUpdate();
    }

    @Override
    public Long countAll() {
        return (Long) session.createQuery("select count(s) from Student s").uniqueResult();
    }
}