package Lesson2.ReverseLinkedList;

public class DemoAppReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedListImpl<>();
        System.out.print("Исходный порядок:");
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.printList();
        System.out.print("Обратный порядок:");
        linkedList.reverseList();
        linkedList.printList();
    }
}
