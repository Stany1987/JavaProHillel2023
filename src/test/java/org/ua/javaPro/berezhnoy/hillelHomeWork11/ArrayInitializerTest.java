package org.ua.javaPro.berezhnoy.hillelHomeWork11;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

class ArrayInitializerTest {


    @Test
    void valuesMustMatch() {
        double[] arr = new double[10];
        ArrayInitializer.init(arr);
        for (int i = 0; i < arr.length; i++) {
            double expectedValue = ArrayInitializer.formula(i, 0);
            assertEquals(expectedValue, arr[i], 0.0001);
        }
    }


    @Test
    void formula() {
        assertEquals(ArrayInitializer.formula(1, PI), 0.7004427387551365, 0);
    }

}