package ua.javaPro.berezhnoy.hillelHomeWork5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    HillelList list = new ArrayList();

    @Test
    void shouldAddElementToArrayTest() {
        list.add("a");
        Assertions.assertEquals("a", list.get(0));
    }

    @Test
    void shouldRemoveElementToArrayTest() {
        list.add("a");
        list.add("b");
        list.remove(0);
        Assertions.assertEquals("b", list.get(0));
    }

    @Test
    void containsElementInArrayTest() {
        list.add("a");
        assertTrue(list.contains("a"));
    }

    @Test
    void shouldFindIndexElementTest() {
        list.add("a");
        Assertions.assertEquals(0, list.indexOf("a"));
// should get -1 if there is no element in the array.
        Assertions.assertEquals(-1, list.indexOf("d"));
    }

    @Test
    void shouldGiveSizeArrayTest() {
        list.add("a");
        list.add("b");
        list.add("c");
        Assertions.assertEquals(3, list.size());

    }

    @Test
    void shouldGetElementByIndexTest() {
        list.add("a");
        Assertions.assertEquals("a", list.get(0));
    }

    @Test
    void shouldGetWholeArray() {
        list.add("a");
        list.add("b");
        Assertions.assertEquals("[a, b]", Arrays.toString(list.getAll()));
    }
}