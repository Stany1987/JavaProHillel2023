package org.ua.javaPro.berezhnoy.hillelHomeWork5;

public class ArrayList implements HillelList {
    public String[] arrayItem;

    public ArrayList() {
        arrayItem = new String[0];
    }

    @Override
    public void add(String item) {
        String[] arrItem = new String[arrayItem.length + 1];
        for (int i = 0; i < arrItem.length; i++) {
            arrItem[i] = item;
        }
        System.arraycopy(arrayItem, 0, arrItem, 0, arrayItem.length);
        arrItem[arrayItem.length] = item;
        arrayItem = arrItem;
    }

    @Override
    public String remove(int index) {
        String[] arrayCopy = new String[arrayItem.length - 1];
        System.arraycopy(arrayItem, 0, arrayCopy, 0, index);
        System.arraycopy(arrayItem, index + 1, arrayCopy, index, arrayItem.length - index - 1);
        arrayItem = arrayCopy;
        return null;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < arrayItem.length; i++) {
            if (item == arrayItem[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
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
    public String get(int index) {
        return arrayItem[index];
    }

    @Override
    public String[] getAll() {
        return arrayItem;
    }
}
