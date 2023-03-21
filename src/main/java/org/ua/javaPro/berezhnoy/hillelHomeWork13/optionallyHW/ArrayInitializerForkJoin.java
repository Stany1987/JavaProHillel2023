package org.ua.javaPro.berezhnoy.hillelHomeWork13.optionallyHW;

import java.util.concurrent.RecursiveAction;

public class ArrayInitializerForkJoin extends RecursiveAction {

    private static final int hold = 20;
    private final double[] array;
    private final int start;
    private final int end;

    public ArrayInitializerForkJoin(double[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    protected void compute(){
        if ( end - start <= hold){
            for (int i = start; i < end ; i++) {
                array[i] = formula(i,array[i]);
            }
        }else {
            int mid = (start+end)/2;
            ArrayInitializerForkJoin left = new ArrayInitializerForkJoin(array,start,mid);
            ArrayInitializerForkJoin right = new ArrayInitializerForkJoin(array,mid,end);
            invokeAll(left,right);
        }
    }
    public static double formula(int i, double value) {
        return value * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0);
    }
}
