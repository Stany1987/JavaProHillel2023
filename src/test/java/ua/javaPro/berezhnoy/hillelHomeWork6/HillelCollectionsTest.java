package ua.javaPro.berezhnoy.hillelHomeWork6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HillelCollectionsTest {

    @Test
    void shouldCountNumberMatchesTest() {
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
        assertEquals(HillelCollections.countOccurance(list, "Chucha"), 3);
    }

    @Test
    void arrayToListTest() {
        Integer[] array = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(HillelCollections.toList(array), list);
    }

    @Test
void shouldReturnUniqueNumbers(){
        List <Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(7);
        list.add(2);

        assertEquals(HillelCollections.findUnique(list).toString(),"[1, 2, 3, 4, 7]");
    }

    @Test
    void shouldCountSameRows (){
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
        assertEquals(HillelCollections.calcOccurance(list).toString(),"[java:5, c++:2, python:2, javaScript:2," +
                " list:1, ....:1]");
    }

@Test
    void mustFindNumberNames(){
        List<String> listName=new ArrayList<>();
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
     assertEquals(HillelCollections.findOccurance(listName).toString(),"[{name: \"cat\" , ocurrencia: 5}, " +
             "{name: \"dog\" , ocurrencia: 2}, {name: \"turtle\" , ocurrencia: 2}, {name: \"parrot\" , ocurrencia: 3}, " +
             "{name: \"bird\" , ocurrencia: 1}]");
}
}