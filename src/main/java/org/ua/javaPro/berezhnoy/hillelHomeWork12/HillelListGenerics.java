package org.ua.javaPro.berezhnoy.hillelHomeWork12;

public interface HillelListGenerics <T> {


    void add(T item);

    T remove(int index);

    boolean contains(T item);

    int indexOf(T item);

    int size();

    T get(int index);

    Object[] getAll();



}
