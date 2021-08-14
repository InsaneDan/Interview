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


//NB! Сдвиг нумерации id связана с предыдущими запусками -
//нумерация продолжается дальше (автоинкремент) после удаления предшествующих записей.

/*РЕЗУЛЬТАТ (консоль):

Начать транзакцию...
Количество записей в БД: 0
Добавление новых записей: 1000
Количество записей в БД: 1000
Очистка таблицы (удаление всех записей)
Количество записей в БД: 0

Добавление новых записей: 10
Полный список студентов:
Student {id= 10091, name= Student_0001, mark= 8}
Student {id= 10092, name= Student_0002, mark= 6}
Student {id= 10093, name= Student_0003, mark= 8}
Student {id= 10094, name= Student_0004, mark= 8}
Student {id= 10095, name= Student_0005, mark= 6}
Student {id= 10096, name= Student_0006, mark= 4}
Student {id= 10097, name= Student_0007, mark= 6}
Student {id= 10098, name= Student_0008, mark= 9}
Student {id= 10099, name= Student_0009, mark= 6}
Student {id= 10100, name= Student_0010, mark= 5}
Количество записей в БД: 10

Удаление 3 записи в таблице, Student_Id = 10093
Полный список студентов:
Student {id= 10091, name= Student_0001, mark= 8}
Student {id= 10092, name= Student_0002, mark= 6}
Student {id= 10094, name= Student_0004, mark= 8}
Student {id= 10095, name= Student_0005, mark= 6}
Student {id= 10096, name= Student_0006, mark= 4}
Student {id= 10097, name= Student_0007, mark= 6}
Student {id= 10098, name= Student_0008, mark= 9}
Student {id= 10099, name= Student_0009, mark= 6}
Student {id= 10100, name= Student_0010, mark= 5}

Изменить имя предпоследнего в списке студента...
старое имя – Student_0009 новое имя – NEW_STUDENT_0000
Student {id= 10099, name= NEW_STUDENT_0000, mark= 6}

Полный список студентов:
Student {id= 10091, name= Student_0001, mark= 8}
Student {id= 10092, name= Student_0002, mark= 6}
Student {id= 10094, name= Student_0004, mark= 8}
Student {id= 10095, name= Student_0005, mark= 6}
Student {id= 10096, name= Student_0006, mark= 4}
Student {id= 10097, name= Student_0007, mark= 6}
Student {id= 10098, name= Student_0008, mark= 9}
Student {id= 10099, name= NEW_STUDENT_0000, mark= 6}
Student {id= 10100, name= Student_0010, mark= 5}
Количество записей в БД: 9

Удалить все записи из таблицы...
Очистка таблицы (удаление всех записей)
Завершить транзакцию...
Закрыть сессию...
Закрыть фабрику HibernateUtil...
---------- Тест завершен ----------
авг. 14, 2021 4:25:13 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost/interview_hibernate_demo]

Process finished with exit code 0

 */