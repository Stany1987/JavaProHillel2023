package ua.javaPro.berezhnoy.hillelHomeWork5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HillelList list = new ArrayList();
        list.add("e");
        list.add("q");
        list.add("w");
        list.add("fsag");

        System.out.println(Arrays.toString(list.getAll()));
        System.out.println(list.size());
        System.out.println(list.indexOf("w"));
        System.out.println(list.contains("ere"));
        list.remove(2);
        System.out.println(list.get(2));
        System.out.println(Arrays.toString(list.getAll()));
    }
}
