package ua.javaPro.berezhnoy.hillelHomeWork6.phonebook;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    static HashMap<String, ArrayList<String>> name = new HashMap<>();

    public static void add(String nameKey, String number) {
        ArrayList<String> subscriberData = new ArrayList<>();
        if (name.containsKey(nameKey)) {
            subscriberData = name.get(nameKey);
            subscriberData.add(number);
        } else {
            subscriberData.add(number);
            name.put(nameKey, subscriberData);
        }
    }

    public static String find(String nameGet, int index) {
        if (name.size() >= index) {
            return nameGet + " " + name.get(nameGet).get(index);
        }
        return null;
    }

    public static String findAll(String nameGet) {
        if (name.containsKey(nameGet)) {
            return nameGet + " " + name.get(nameGet);
        } else {
            return null;
        }
    }
}


