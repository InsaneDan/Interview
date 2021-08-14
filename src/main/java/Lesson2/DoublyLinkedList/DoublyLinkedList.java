package Lesson2.DoublyLinkedList;

public interface DoublyLinkedList<E> extends Iterable<E> {

    // двунаправленный DoublyLinkedList
    int size();
    boolean contains(E value);
    boolean isEmpty();
    void insert(E value, int index);
    void insertHead(E value);
    void insertTail(E value);
    boolean remove(E value);
    E removeByIndex(int index);
    E removeHead();
    E removeTail();
    E get(int index);
    E getFirst();
    E getLast();

    void printList();

    class Node<E> {
        E value;
        Node<E> next;
        Node<E> previous;

        public Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
