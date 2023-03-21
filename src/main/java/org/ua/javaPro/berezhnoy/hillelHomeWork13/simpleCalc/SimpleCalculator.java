package org.ua.javaPro.berezhnoy.hillelHomeWork13.simpleCalc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class SimpleCalculator {
    public int square(int num) {
        return num * num;
    }

    public int squareSum(int first, int second) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return square(first);
            }
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return square(second);
            }
        });
        try {
            int result1 = future1.get();
            int result2 = future1.get();
            return result1 + result2;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return 0;
        }
    }
}