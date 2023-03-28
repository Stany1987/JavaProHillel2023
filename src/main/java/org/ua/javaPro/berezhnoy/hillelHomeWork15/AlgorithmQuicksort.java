package org.ua.javaPro.berezhnoy.hillelHomeWork15;

public class AlgorithmQuicksort {

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);

            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr,partitionIndex + 1,right);
        }

    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;

            }
        }
        int swap = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = swap;
        return i + 1;
    }

//   Я думаю , что сложность O(n log n).Но это не точно )))
String link= "https://www.baeldung.com/java-quicksort";// читал про него тут //

}
