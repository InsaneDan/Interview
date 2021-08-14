package Lesson2.ReverseLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListImpl<E> implements LinkedList<E> {

    protected int size;
    protected Node<E> firstElement;

    @Override
    public void reverseList() {
        Node<E> previous = null;
        Node<E> current = firstElement;
        Node<E> next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        firstElement = previous;
    }


    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;

        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }

            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public void printList() {
        System.out.println();
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
    }

    @Override
    public E getFirst() {
        return firstElement != null ? firstElement.item : null;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> itr = new Iterator<E>() {

            private final LinkedListImpl<E> list = LinkedListImpl.this;
            private Node<E> current = list.firstElement;
            private Node<E> previous = null;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                E nextValue = current.item;
                previous = current;
                current = current.next;
                return nextValue;
            }

            @Override
            public void remove() {
                if (previous == null) {
                    list.firstElement = current.next;
                    reset();
                } else {
                    previous.next = current.next;
                    if ( !hasNext() ) {
                        reset();
                    } else {
                        current = current.next;
                    }
                }
            }

            public void reset() {
                current = list.firstElement;
                previous = null;
            }
        };
        return itr;
    }




}

