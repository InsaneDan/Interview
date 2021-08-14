package Lesson5.Hibernate;

import Lesson5.Hibernate.model.Student;
import Lesson5.Hibernate.repository.StudentRepository;
import Lesson5.Hibernate.repository.StudentRepositoryImpl;
import Lesson5.Hibernate.services.StudentService;
import Lesson5.Hibernate.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class Tests {

    private StudentService studentService;
    private Session session;

    public Tests() {
        this.session = HibernateUtil
                .getSessionFactory()
                .openSession();
        StudentRepository studentRepository = new StudentRepositoryImpl(session);
        studentService = new StudentService(studentRepository);
    }

    public void start() {
        System.out.println("\nНачать транзакцию...");
        session.beginTransaction();

        studentService.printTotalCount();
        studentService.addStudents(1000);
        studentService.printTotalCount();
        studentService.removeAllStudents();
        studentService.printTotalCount();
        System.out.println();

        studentService.addStudents(10);
        studentService.printAllStudents();
        studentService.printTotalCount();
        System.out.println();

        List<Student> studentsList = studentService.findAllStudents();
        Long id = studentsList.get(2).getId();
        System.out.println("Удаление 3 записи в таблице, Student_Id = " + id);
        studentService.deleteStudentById(id);
        studentService.printAllStudents();
        System.out.println();

        String newName = "NEW_STUDENT_0000";
        studentsList = studentService.findAllStudents();
        Student student = studentsList.get(studentsList.size()-2);
        System.out.println("Изменить имя предпоследнего в списке студента...");
        id = student.getId();
        System.out.println("старое имя – " + student.getName() + " новое имя – " + newName);
        studentService.renameStudent(id, newName);
        System.out.println(studentService.findStudentById(id));
        System.out.println();

        studentService.printAllStudents();
        studentService.printTotalCount();
        System.out.println();

        System.out.println("Удалить все записи из таблицы...");
        studentService.removeAllStudents();
        System.out.println("Завершить транзакцию...");
        session.getTransaction().commit();
        System.out.println("Закрыть сессию...");
        session.close();
        System.out.println("Закрыть фабрику HibernateUtil...");
        HibernateUtil.shutdown();
    }

}
