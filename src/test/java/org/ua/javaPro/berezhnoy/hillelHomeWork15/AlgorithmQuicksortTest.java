package org.ua.javaPro.berezhnoy.hillelHomeWork15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmQuicksortTest {
AlgorithmQuicksort algorithmQuicksort=new AlgorithmQuicksort();
    @Test
    void testQuickSort() {
        int [] arr = {8,2,4,6,1,3,7,5};
        algorithmQuicksort.quickSort(arr,0,arr.length-1);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8},arr);
    }

    @Test
    void testQuickSortEmptyArray(){
        int [] arr ={};
        algorithmQuicksort.quickSort(arr,0, arr.length-1);
        assertArrayEquals(new int[]{},arr);
    }
}