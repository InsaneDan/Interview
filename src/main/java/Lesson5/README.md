# Подготовка к собеседованию Java-разработчика

<details>
<summary>Урок 5. Hibernate</summary>

1. Создать базу данных Student с полями id, name, mark.
2. Создать сущность Student и добавить в нее аннотации. Поле id должно заполняться автоматически.
3. Создать конфигурационный файл hibernate.cfg.xml, в котором указать свойства для подключения к БД и список классов с аннотациями Entity.
4. Создать класс со статическим методом, который возвращает объект SessionFactory.
5. Создать DAO-слой с операциями добавления, удаления, изменения сущности, выборки записи по ID и всех записей.
6. Добавить 1000 записей в таблицу Student.
7. Проверить работоспособность приложения, выполнить методы по удалению, изменению, добавлению записей, а также выборки одной и всех записей.


   **Решение (Hybernate package)**  
1. В MySQL предварительно создана схема 'interview_hibernate_demo'. 
   Таблица Students создается, если еще не создана, или обновляется с помощью Flyway.
2. Сущность Student: аннотация @Entity, аннотация @Table, конструктор по умолчанию,
   поле @Id, автозаполнение @GeneratedValue(strategy = GenerationType.IDENTITY) + AUTO_INCREMENT в скрипте создания таблицы.
3. В hibernate.cfg.xml указаны свойства для подключения к БД (драйвер – com.mysql.cj.jdbc.Driver, url – jdbc:mysql://localhost/interview_hibernate_demo и др.), 
   класс-сущность (mapping class) – "Lesson5.Hibernate.model.Student".
4. Класс HibernateUtil содержит метод public static SessionFactory getSessionFactory, который возвращает SessionFactory.
5. DAO-слой: базовый интерфейс StudentRepository extends BaseRepository<Student, Long>, реализация – StudentRepositoryImpl. 
   При создании объекта в конструкторе передается текущая сессия (session).
6. Добавление записей в БД и остальные операции вынесены в отдельный сервисный слой (StudentService).
7. Точка входа – DemoAppHibernate: запускается метод Tests().start(), который проверяет все методы сервисного слоя.
   

Для упрощения все тесты проводятся в рамках **_одной транзакции_**!!!

</details>
