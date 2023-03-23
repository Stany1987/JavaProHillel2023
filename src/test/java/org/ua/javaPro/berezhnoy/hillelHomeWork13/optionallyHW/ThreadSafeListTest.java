package org.ua.javaPro.berezhnoy.hillelHomeWork13.optionallyHW;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeListTest {

    @Test
    void mustAddAndReceiveElement() {
        ThreadSafeList<String> list = new ThreadSafeList<>();
        list.add("a");
        list.add("b");
       assertEquals("a",list.get(0));
       assertEquals("b",list.get(1));

    }

@Test
    void mustRemoveElement(){
        ThreadSafeList<String> list =new ThreadSafeList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove(1);
        assertEquals("c",list.get(1));
}
}