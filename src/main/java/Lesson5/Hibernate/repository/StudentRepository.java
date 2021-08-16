package Lesson5.Hibernate.repository;

import Lesson5.Hibernate.model.Student;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student, Long>{
    Long countAll();
    List<Student> mergeBatch(List<Student> entities);
    List<Student> findByName(String name);
    boolean removeAll();
}
