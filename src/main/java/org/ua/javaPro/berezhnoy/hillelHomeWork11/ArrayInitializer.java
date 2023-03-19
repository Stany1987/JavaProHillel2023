package org.ua.javaPro.berezhnoy.hillelHomeWork11;

public class ArrayInitializer {

    public static void init(double[] array) {
        int halfLength = array.length / 2;
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < halfLength; i++) {
                    array[i] = array[halfLength + i] = formula(i, array[i]);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < halfLength; i++) {
                    array[i] = array[halfLength + i] = formula(i, array[i]);
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double formula(int i, double value) {
        return value * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0);
    }

}
