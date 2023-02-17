package ua.javaPro.berezhnoy.hillelHomeWork6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HillelCollectionsTest {

    @Test
    void shouldCountNumberMatchesTest() {
        var hillelCollections = new HillelCollections();
        List list = new ArrayList<String>();
        list.add("Cat");
        list.add("Dog");
        list.add("Lion");
        list.add("Fretca");
        list.add("Chucha");
        list.add("Chucha");
        list.add("Bona");
        list.add("Busia");
        list.add("Lemon");
        list.add("Krasunia");
        list.add("Carrot");
        list.add("Turtle");
        list.add("Chucha");
        assertEquals(hillelCollections.countOccurance(list, "Chucha"), 3);
    }

    @Test
    void arrayToListTest() {
        var hillelCollections = new HillelCollections();
        Integer[] array = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(hillelCollections.toList(array), list);
    }

    @Test
    void shouldReturnUniqueNumbers() {
        var hillelCollections = new HillelCollections();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(7);
        list.add(2);

        assertEquals(hillelCollections.findUnique(list).toString(), "[1, 2, 3, 4, 7]");
    }

    @Test
    void shouldCountSameRows() {
        var hillelCollections = new HillelCollections();
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("c++");
        list.add("python");
        list.add("javaScript");
        list.add("java");
        list.add("c++");
        list.add("java");
        list.add("java");
        list.add("python");
        list.add("java");
        list.add("javaScript");
        list.add("list");
        list.add("....");
        assertEquals(hillelCollections.calcOccurance(list).toString(), "[java:5, c++:2, python:2, javaScript:2," +
                " list:1, ....:1]");
    }

    @Test
    void mustFindNumberNames() {
        var hillelCollections = new HillelCollections();
        List<String> listName = new ArrayList<>();
        listName.add("cat");
        listName.add("dog");
        listName.add("turtle");
        listName.add("parrot");
        listName.add("parrot");
        listName.add("cat");
        listName.add("cat");
        listName.add("dog");
        listName.add("cat");
        listName.add("parrot");
        listName.add("turtle");
        listName.add("cat");
        listName.add("bird");
        assertEquals(hillelCollections.findOccurance(listName).toString(),
                "[WordOccurrence[name=cat, occurance=5]," +
                " WordOccurrence[name=dog, occurance=2], WordOccurrence[name=turtle, occurance=2], " +
                "WordOccurrence[name=parrot, occurance=3], WordOccurrence[name=bird, occurance=1]]");
    }
}