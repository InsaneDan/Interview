package Lesson5.Hibernate.services;

import Lesson5.Hibernate.model.Student;
import Lesson5.Hibernate.repository.StudentRepository;
import com.mysql.cj.jdbc.exceptions.OperationNotSupportedException;

import java.util.List;
import java.util.Optional;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    public StudentRepository getStudentRepository() {
//        return studentRepository;
//    }

    public void printTotalCount() {
        System.out.println("Количество записей в БД: " + studentRepository.countAll());
    }

    public Student findStudentById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public void printAllStudents(){
        System.out.println("Полный список студентов:");
        studentRepository.findAll().forEach(System.out::println);
    }

    public void addStudents(int amount) {
        System.out.println("Добавление новых записей: " + amount);
        for (int i = 1; i <= amount; i++) {
            studentRepository.save(
                    new Student("Student_" + "0".repeat(4 - Integer.toString(i).length()) + i, (int) (Math.random() * 10))
            );
        }
    }

    public void removeAllStudents() {
        System.out.println("Очистка таблицы (удаление всех записей)");
        studentRepository.removeAll();
    }

    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }

    public Student renameStudent(Long id, String newName){

        if (studentRepository.countAll() == 0) return null;
        Student student = studentRepository.findById(id);
        if (student != null) {
            student.setName(newName);
            studentRepository.update(student);
            return student;
        }
        return null;
    }


}
