# Подготовка к собеседованию Java-разработчика

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
