package ua.javaPro.berezhnoy.hillelHomeWork4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        String[][] array2 = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "S", "12"},
                {"13", "14", "15", "16"}};
        try {
            System.out.println("Array " + ArrayValueCalculator.doCalc(array));
            System.out.println("Array2 " + ArrayValueCalculator.doCalc(array2));
        } catch (ArraySizeException | ArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
