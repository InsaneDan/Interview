package Lesson2.ArrayList;

import java.util.*;
import java.util.function.UnaryOperator;

public interface CustomArrayList<E> {
    // Query Operations
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Object[] toArray();

    // Modification Operations
    boolean add(E value);
    boolean removeValue(Object o);
    void clear();

    void trimCapacity();

    // Positional Access Operations
    E get(int index);
    E set(int index, E value);
    boolean add(int index, E value);
    E remove(int index);

    // Search Operations
    int indexOf(Object o);

//    // List Iterators
//    Iterator<E> iterator();
//    ListIterator<E> listIterator();


}
