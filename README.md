# Подготовка к собеседованию Java-разработчика

<details>
<summary>Урок 1. Пробегаем по ООП</summary>

1. Создать builder для класса Person со следующими полями: String firstName, String lastName, String middleName, String country, String address, String phone, int age, String gender.  
   **Решение (BuilderPattern package):**  
   Класс Person с внутренним классом Builder; консольный вывод - DemoBuilder.


2. Описать ошибки в коде (см. задание в методичке) и предложить варианты оптимизации.  
   **Решение (CarsCodeReview package):**  
   Код-ревью в комментариях и продублирован в Answer.txt


3. Написать пример кода, который реализует принцип полиморфизма, на примере фигур — круг, квадрат, треугольник.  
   **Решение (ShapeDecorator package):**  
   Реализация принципа полиморфизма на примере фигур (круг, квадрат, треугольник) + паттерн Декоратор (для повторения).
</details>


<details>
<summary>Урок 2. Алгоритмы и структуры данных</summary>

1. Реализовать основные методы связанного списка.  
   **Решение (DoublyLinkedList):**  
   Интерфейс DoublyLinkedList и его реализация DoublyLinkedListImpl;
   демонстрация работы - DemoAppDoublyLinkedList;
   результат вывода в консоль - DemoAppDoublyLinkedList.txt


2. Реализовать основные методы ArrayList.  
   **Решение (ArrayList):**  
   Интерфейс CustomArrayList и его реализация ArrayListImpl;
   тестирование - DemoAppArrayList; результат вывода в консоль - DemoAppArrayList.txt


3. Инверсировать односвязный LinkedList без создания дополнительных структур данных (массивов или списков/стэков)  
   **Решение (ReverseLinkedList)**  
   Интерфейс LinkedList, реализация LinkedListImpl; указатель на текущую позицию -
   current, указатель на предыдущий элемент - previous, проходим циклом по всем
   элементам, начиная с головы, и перебрасываем ссылки со следующего элемента на
   предыдущий.
</details>


<details>
<summary>Урок 3. Java Core. Углубленное изучение</summary>

1. Реализовать программу, в которой два потока поочередно пишут ping и pong.  
   **Решение (PingPong):**  
   Потокам присвоены имена (ping и pong); текущий поток в синхронизированном методе
   выводит в консоль свое имя ~>
   делает паузу (sleep) ~>
   будит другой поток ~>
   засыпает (wait).
   Вместо имен можно задать произвольное сообщение и передавать его для печати.


2. Реализовать потокобезопасный счетчик с помощью интерфейса Lock.  
   **Решение (ConcurrentCounter):**  
   Одновременно стартуют 3 потока, которые увеличивают значение 3 счетчиков на 1 за заданное количество итераций.
   Каждый поток обрабатывает 2 счетчика: 1) counter1 и общий (counter3); 2) counter2 и общий; 3) общий счетчик дважды;
   т.е. общий счетчик увеличивается в первом, втором и два раза в третьем потоке.
   Блокировка счетчика – по объекту Lock (ReentrantLock).  
   В результате 100 итераций счетчики должны увеличиться следующим образом:   
   1 поток: counter1 +100, общий +100;  
   2 поток: counter2 +100, общий +100;  
   3 поток: общий +100, общий +100.  
   Итог: counter1 = 100, counter2 = 100, общий = 400.
</details>


<details>
<summary>Урок 4. Базы данных</summary>

Задача про кинотеатр.  
У фильма, который идет в кинотеатре, есть название, длительность (пусть будет 60, 90 или 120 минут), цена билета (в разное время и дни может быть разной), время начала сеанса (один фильм может быть показан несколько раз в разное время и с разной ценой билета). Есть информация о купленных билетах (номер билета, на какой сеанс).

**Задания:**
* Составить грамотную нормализованную схему хранения этих данных в БД. Внести в нее 4–5 фильмов, расписание на один день и несколько проданных билетов.
* Сделать запросы, считающие и выводящие в понятном виде:
   - ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени. Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
   - перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;
   - список фильмов, для каждого — с указанием общего числа посетителей за все время, среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли). Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;
   - число посетителей и кассовые сборы, сгруппированные по времени начала фильма: с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).

**Решение (CinemaTimetable):**  
SQL-скпипт (MySQL) + модель в jpg-файле (связи, индексы, внешние ключи).  
Схема: cinema. Таблицы: movies, halls, seats, sessions, prices, tickets. Данные предзаполнены для решения задания.
Запрос для вывода накладывающихся друг на друга фильмов сделал в двух вариантах:
1) вывод "в лоб" (расчет времени окончания каждого сеанса, inner join, выборка тех вариантов, в которых начало сеанса попадает в диапазон между началом и окончанием другого сеанса, наложения сеансов на самих себя исключены по условию);
2) объединенное решение накладок в сеансах и длительные перерывы (расчет даты-времени начала и окончания сеансов, сведение данных о сеансах и фильмах, выборка по условию (только в 1 зале),  сортировка по времени начала (для последующего использования в функции LEAD), добавление поля с началом следующего сеанса (с помощью оконной функции LEAD), продолжительность перерыва в минутах и описание ошибки ("наложение сеансов", "нет перерыва" или "долгий перерыв").


3) Статистика по каждому фильму и итог – через UNION;
4) Группировка числа посетителей и кассовые сборы по каждому фильму – через поля с CASE WHEN...

Результаты запросов приведены после каждого запроса и закомментированы.
</details>


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
   При создании объекта в конструкторе передается фабрика (SessionFactory), в каждом методе создается текущая сессия,
   открывается транзакция, выполняется основное действие, закрывается транзакция и сессия. В связи с этим пакетные операции.
   требующие выполнения нескольких действий с базой данных в рамках одной транзакции, вынесены в отдельные методы
   (например, метод mergeBatch).
6. Основная логика приложения (обновление записей в БД и др. операции) вынесена в отдельный сервисный слой (StudentService).
7. Точка входа – DemoAppHibernate: запускается метод Tests().start(), который проверяет все методы сервисного слоя.

</details>


<details>
<summary>Урок 6. Java Web</summary>

1. Установить и настройте Apache Tomcat.
2. Написать сервлет, который выводит надпись Hello World.
3. Сконфигурировать его так, чтобы при обращении localhost:8080/hello в окне браузера появлялась надпись HelloWorld.


**Решение (module Lesson6-Java-Web):**
* Установлен сервер приложений apache-tomcat-9.0.52, добавлен пользователь admin, назначены права (manager-gui,manager-script).
* В зависимости pom.xml добавлен tomcat7-maven-plugin. Для деплоя: run clean install tomcat7:redeploy. Приложение развернуто на сервере по адресу http://localhost:8080/interview.
* Стартовая страница (index.jsp) содержит 2 заголовка первого уровня (в латиннице и кириллице) и
  ссылку на сервлет "helloServlet" с эндпоинтом "/hello", который выводит надпись "Hello World!".

</details>

<details>
<summary>Урок 7. Spring</summary>

1. Создать сущность Student с полями id, name, age.
2. Сконфигурировать Spring JPA контекст.
3. Создать репозиторий для вставки, удаления, изменения и просмотра студентов.
4. Создать контроллер с методами, которые вызывают методы репозитория.
5. Создать JSP-страницу, на которой в таблице отобразить список студентов с кнопками для добавления, обновления и удаления записей.
6. Привязать к каждой кнопке действие, которое будет передаваться на контроллер.

**Решение (module Lesson7-Spring):**
* Spring-boot application разворачивается на http://localhost:8989/interview/index.html;
* сущность Student + StudentRepository + StudentService + StudentController;
* база данных H2 DB (in memory), создается список из 10 студентов;
* static-блок: вместо JSP-страницы созданы index.html + index.js.

</details>
