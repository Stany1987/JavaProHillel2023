package ua.javaPro.berezhnoy.hillelHomeWork4;

public class ArrayValueCalculator {

    public static int doCalc(String[][] array)  {
        int sum = 0;
        if (array.length != 4) {
            throw new ArraySizeException("Wrong size");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new ArraySizeException("Wrong size");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new ArrayDataException("Invalid array format in cell: "
                            + "String: " + i + " " + "Column: " + j + " "
                            + "Symbol: " + array[i][j] + " " + ex);
                }
            }
        }

        return sum;
    }
}