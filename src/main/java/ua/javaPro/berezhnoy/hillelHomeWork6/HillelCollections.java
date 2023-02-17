package ua.javaPro.berezhnoy.hillelHomeWork6;

import java.util.*;

public class HillelCollections {

    public int countOccurance(List<String> arrList, String str) {
        return Collections.frequency(arrList, str);
    }

    public List<Integer> toList(Integer[] array) {
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
            for (String s : list) {
                if (Objects.equals(list.get(i), s)) {
                    count++;
                }
            }
            {
                copyList.add(list.get(i) + ":" + count);
            }
        }
        for (String s : copyList) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }

        return result;
    }

    public List<WordOccurrence> findOccurance(List<String> listName) {
        List result = new ArrayList<WordOccurrence>();
        List<String> addWords = new ArrayList<>();
        for (String str : listName) {
            if (!addWords.contains(str)) {
                result.add(new WordOccurrence(str, countOccurance(listName, str)));
                addWords.add(str);
            }
        }

        return result;
    }
}









