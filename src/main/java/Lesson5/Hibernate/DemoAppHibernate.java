package Lesson5.Hibernate;

import org.flywaydb.core.Flyway;

public class DemoAppHibernate {

    public static void main(String[] args) {
        // создаем или обновляем таблицу базы данных
        Flyway database = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/interview_hibernate_demo", "root", "1234")
                .load();
        database.migrate();

        // запускаем тесты
        new Tests().start();
        System.out.println("---------- Тест завершен ----------");
    }
}


//NB! Сдвиг нумерации id связана с предыдущими тестами -
//нумерация продолжается дальше (автоинкремент) после удаления предшествующих записей.

/*РЕЗУЛЬТАТ (консоль):

Количество записей в БД: 623

Создаем список из 1000 студентов и добавляем в БД...
Добавление новых записей: 1000
Количество записей в БД: 1623
Очистка таблицы (удаление всех записей)
Количество записей в БД: 0

Создаем новый список из 10 студентов и добавляем в БД...
Добавление новых записей: 10
Полный список студентов:
Student {id= 1624, name= Student_0001, mark= 6}
Student {id= 1625, name= Student_0002, mark= 7}
Student {id= 1626, name= Student_0003, mark= 2}
Student {id= 1627, name= Student_0004, mark= 1}
Student {id= 1628, name= Student_0005, mark= 3}
Student {id= 1629, name= Student_0006, mark= 7}
Student {id= 1630, name= Student_0007, mark= 7}
Student {id= 1631, name= Student_0008, mark= 2}
Student {id= 1632, name= Student_0009, mark= 6}
Student {id= 1633, name= Student_0010, mark= 4}
Количество записей в БД: 10

Удаление 3 записи в таблице, Student_Id = 1626
Полный список студентов:
Student {id= 1624, name= Student_0001, mark= 6}
Student {id= 1625, name= Student_0002, mark= 7}
Student {id= 1627, name= Student_0004, mark= 1}
Student {id= 1628, name= Student_0005, mark= 3}
Student {id= 1629, name= Student_0006, mark= 7}
Student {id= 1630, name= Student_0007, mark= 7}
Student {id= 1631, name= Student_0008, mark= 2}
Student {id= 1632, name= Student_0009, mark= 6}
Student {id= 1633, name= Student_0010, mark= 4}

Изменить имя предпоследнего в списке студента...
старое имя – Student_0009 новое имя – NEW_STUDENT_0000
Student {id= 1632, name= NEW_STUDENT_0000, mark= 6}

Полный список студентов:
Student {id= 1624, name= Student_0001, mark= 6}
Student {id= 1625, name= Student_0002, mark= 7}
Student {id= 1627, name= Student_0004, mark= 1}
Student {id= 1628, name= Student_0005, mark= 3}
Student {id= 1629, name= Student_0006, mark= 7}
Student {id= 1630, name= Student_0007, mark= 7}
Student {id= 1631, name= Student_0008, mark= 2}
Student {id= 1632, name= NEW_STUDENT_0000, mark= 6}
Student {id= 1633, name= Student_0010, mark= 4}
Количество записей в БД: 9

Удалить все записи из таблицы...
Очистка таблицы (удаление всех записей)
Закрыть фабрику HibernateUtil...
---------- Тест завершен ----------
авг. 16, 2021 1:54:04 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost/interview_hibernate_demo]

Process finished with exit code 0


 */