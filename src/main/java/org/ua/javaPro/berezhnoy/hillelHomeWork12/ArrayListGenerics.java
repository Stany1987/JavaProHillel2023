package org.ua.javaPro.berezhnoy.hillelHomeWork12;

import java.util.Arrays;

public class ArrayListGenerics<T> implements HillelListGenerics <T>{
    public T[] arrayItem;

    public ArrayListGenerics() {
        arrayItem = (T[]) new Object[0];
    }

    @Override
    public void add(T item) {
        T[] arrItem = (T[]) new Object[arrayItem.length + 1];
        Arrays.fill(arrItem, item);
        System.arraycopy(arrayItem, 0, arrItem, 0, arrayItem.length);
        arrItem[arrayItem.length] =  item;
        arrayItem = arrItem;
    }

    @Override
    public T remove(int index) {
        T[] arrayCopy = (T[]) new Object[arrayItem.length - 1];
        System.arraycopy(arrayItem, 0, arrayCopy, 0, index);
        System.arraycopy(arrayItem, index + 1, arrayCopy, index, arrayItem.length - index - 1);
        arrayItem = arrayCopy;
        return null;
    }

    @Override
    public boolean contains(T item) {
        for (T t : arrayItem) {
            if (item == t) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < arrayItem.length; i++) {
            if (item == arrayItem[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return arrayItem.length;
    }

    @Override
    public T get(int index) {
        return  arrayItem[index];
    }


    @Override
    public T[] getAll() {
       return arrayItem;
    }
}
