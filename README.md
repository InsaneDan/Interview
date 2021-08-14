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
