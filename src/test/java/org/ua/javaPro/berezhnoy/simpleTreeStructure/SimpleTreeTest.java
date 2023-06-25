package org.ua.javaPro.berezhnoy.simpleTreeStructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SimpleTreeTest {
    private SimpleTree tree;

    @BeforeEach
    public void setUp() {
        tree = new SimpleTree();
    }

    @Test
    public void testAddAndTraverse() {
        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(14);
        tree.add(4);
        tree.add(7);
        tree.add(13);

        String expectedTraversal = "1 3 4 6 7 8 10 13 14";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);

        tree.traverse();

        String actualTraversal = outputStream.toString().trim();

        System.setOut(originalPrintStream);

        assertEquals(expectedTraversal, actualTraversal);
        log.info("{},{}", expectedTraversal, actualTraversal);
    }
}