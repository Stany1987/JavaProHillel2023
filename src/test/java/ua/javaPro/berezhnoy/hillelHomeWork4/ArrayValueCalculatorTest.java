package ua.javaPro.berezhnoy.hillelHomeWork4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayValueCalculatorTest {
    String[][] array = {{"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}};

    String[][] arrayIncorrectLength = {{"1", "2", "3", "4"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}};

    String[][] arrayWrongSymbol = {{"1", "2", "3", "4"},
            {"5", "m", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}};


    @Test
    public void arrayTrueSum() {
        assertEquals(ArrayValueCalculator.doCalc(array), 136);
    }

    @Test
    void shouldThrowExceptionForWrongArraySize() {
        var arraySizeException = Assertions.assertThrows(ArraySizeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ArrayValueCalculator.doCalc(arrayIncorrectLength);
            }
        });
        Assertions.assertEquals("Wrong size", arraySizeException.getMessage());
    }

    @Test
    void shouldThrowExceptionForWrongSymbolTest() {
        var arrayDataException = Assertions.assertThrows(ArrayDataException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ArrayValueCalculator.doCalc(arrayWrongSymbol);
            }
        });
        Assertions.assertEquals(arrayDataException.getMessage(), arrayDataException.getMessage());
    }
}