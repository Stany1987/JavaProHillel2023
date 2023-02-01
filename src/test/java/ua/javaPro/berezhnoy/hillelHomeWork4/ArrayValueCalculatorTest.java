package ua.javaPro.berezhnoy.hillelHomeWork4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ArrayValueCalculatorTest {
    String[][] array = {{"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}};


    @Test
    public void arrayTrue() {
        assertDoesNotThrow(() -> ArrayValueCalculator.doCalc(array));
    }

    @Test
    void arraySize() {
        var arraySizeException = Assertions.assertThrows(ArraySizeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ArrayValueCalculator.doCalc(array);
            }
        });
        Assertions.assertEquals("Wrong size", arraySizeException.getMessage());
    }

    @Test
    void intParsTest() throws ArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += Integer.parseInt(array[i][j]);
            }
        }
        Assertions.assertEquals(sum, ArrayValueCalculator.doCalc(array));
    }

    @Test
    void dataTest() {
        var arrayDataException = Assertions.assertThrows(ArrayDataException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ArrayValueCalculator.doCalc(array);
            }
        });
        Assertions.assertEquals(arrayDataException.getMessage(), arrayDataException.getMessage());
    }
}