package Lesson2.ArrayList;


public class DemoAppArrayList {
    public static void main(String[] args) {

        ArrayListImpl<Integer> arrayList = new ArrayListImpl<>();
        System.out.println("Создан пустой ArrayList:");
        System.out.println(arrayList.toStringFullData());

        System.out.println("\nДобавление 10 элементов: ");
        for (int i = 0; i < 10; i++) { // простое добавление в конец
            arrayList.add(i * 10);
        }
        System.out.println(arrayList);

        System.out.println("\nПроверяем увеличение емкости ArrayList'а: ");
        System.out.println(arrayList.toStringFullData());

        System.out.println("\nДобавление 2 элементов (c индексом 2, потом 4): ");
        arrayList.add(2,100); // вставка по индексу
        arrayList.add(4,200);
        System.out.println(arrayList);

        System.out.println("\nЗамена значения 4 элемента списка (с индексом 3): ");
        arrayList.set(3, 1000);
        System.out.println(arrayList);

        System.out.println("\nУдаление 4 элемента списка (с индексом 3): ");
        arrayList.remove(3);
        System.out.println(arrayList);

        System.out.println("\nУдаление элемента =30: ");
        arrayList.removeValue(30);
        System.out.println(arrayList);

        System.out.println("\nУдаление последнего элемента: ");
        arrayList.remove(arrayList.size);
        System.out.println(arrayList);

        System.out.println("\nУменьшить емкость списка (capacity): ");
        System.out.println(arrayList.toStringFullData());
        arrayList.trimCapacity();
        System.out.println(arrayList.toStringFullData() + " <~~~ после 'выравнивания'");

        System.out.println("\nОчистка списка: ");
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println(arrayList.toStringFullData());
        arrayList.trimCapacity();
        System.out.println(arrayList.toStringFullData());
        System.out.println("<~~~ после 'выравнивания' пустого массива, устанавливается начальная емкость");
    }

}
