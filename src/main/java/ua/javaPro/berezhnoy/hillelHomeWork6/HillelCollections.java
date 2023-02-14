package ua.javaPro.berezhnoy.hillelHomeWork6;

import java.util.*;

public class HillelCollections {
    List<String> list = new ArrayList<>();

    public static int countOccurance(List<String> arrList, String str) {
        int result = Collections.frequency(arrList, str);
        return result;
    }

    public static List<Integer> toList(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        return list;
    }

    public static List<Integer> findUnique(List<Integer> numbers) {
        List<Integer> copyList = new ArrayList<>();
        for (int i : numbers) {
            if (!copyList.contains(i)) {
                copyList.add(i);
            }
        }
        return copyList;
    }

    public static List<String> calcOccurance(List<String> list) {
        List<String> copyList = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    count++;
                }
            }
            if (!copyList.contains(list.get(i))) ;
            {
                copyList.add(list.get(i) + ":" + count);
            }
        }
        for (int i = 0; i < copyList.size(); i++) {
            if (!result.contains(copyList.get(i))) {
                result.add(copyList.get(i));
            }
        }

        return result;
    }

    public static List<String> findOccurance(List<String> listName) {
        List<String> listCopy = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < listName.size(); i++) {
            int count = 0;
            for (int j = 0; j < listName.size(); j++) {
                if (listName.get(i).equals(listName.get(j))) {
                    count++;
                }
            }
            if (!listCopy.contains(listName.get(i))) {
                listCopy.add("{name: \"" + listName.get(i) + "\" , ocurrencia: " + count + "}");
            }
        }
        for (String i : listCopy) {
            if (!result.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
