# Подготовка к собеседованию Java-разработчика

<details>
<summary>Урок 6. Java Web</summary>

1. Установить и настройте Apache Tomcat.
2. Написать сервлет, который выводит надпись Hello World.
3. Сконфигурировать его так, чтобы при обращении localhost:8080/hello в окне браузера появлялась надпись HelloWorld.
  

   **Решение (module Lesson6-Java-Web):**
* Установлен сервер приложений apache-tomcat-9.0.52, добавлен пользователь admin, назначены права (manager-gui,manager-script).
* В зависимости pom.xml добавлен tomcat7-maven-plugin. Приложение развернуто на сервере по адресу http://localhost:8080/interview.
* Стартовая страница (index.jsp) содержит 2 заголовка первого уровня (в латиннице и кириллице) и 
  ссылку на сервлет "helloServlet" с эндпоинтом "/hello", который выводит надпись "Hello World!".

</details>
