package org.ua.javaPro.berezhnoy.hillelHomeWork13.simpleCalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {
SimpleCalculator simpleCalculator = new SimpleCalculator();

@Test
    void mustConvertSquare (){
    assertEquals(simpleCalculator.square(2),4);
}
    @Test
    void MustAddTwoSquares (){
        assertEquals(simpleCalculator.squareSum(2,2),8);
    }

}