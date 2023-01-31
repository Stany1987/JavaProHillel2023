package ua.javaPro.berezhnoy.hillelHomeWork3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class StringSymbolTest {

    @Test
    void findSymbolOccurance() {
        Assertions.assertEquals(1, StringSymbol.findSymbolOccurance("ad", 'd'));
    }


    @Test
    void findWordPosition() {
        Assertions.assertEquals(1, StringSymbol.findWordPosition("stany", "tany"));
        Assertions.assertNotEquals(-1, StringSymbol.findWordPosition("stany", "tany"));
    }

    @Test
    void stringReverse() {
        Assertions.assertEquals("olleh", StringSymbol.stringReverse("hello"));
    }

    @Test
    void isPalindrome() {
        Assertions.assertEquals(true, StringSymbol.isPalindrome("solos"));
    }



    @Test
    void guessWord() {
            ByteArrayInputStream in = new ByteArrayInputStream("orange".getBytes());
            InputStream inputStream = System.in;
            System.setIn(in);
           StringSymbol.guessWord();
            System.setIn(inputStream);


    }
}