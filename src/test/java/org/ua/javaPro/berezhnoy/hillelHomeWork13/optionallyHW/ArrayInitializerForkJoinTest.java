package org.ua.javaPro.berezhnoy.hillelHomeWork13.optionallyHW;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInitializerForkJoinTest {
    @Test
    public void shouldProperlyInitialize() {
        double[] array = new double[100];
        ArrayInitializerForkJoin initializer = new ArrayInitializerForkJoin(array, 0, 100);
        initializer.invoke();
        for (int i = 0; i < array.length; i++) {
            assertEquals(ArrayInitializerForkJoin.formula(i, 0), array[i], 0.01);
        }
    }

}