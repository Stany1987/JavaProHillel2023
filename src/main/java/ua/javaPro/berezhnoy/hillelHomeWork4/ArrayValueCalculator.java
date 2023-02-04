package ua.javaPro.berezhnoy.hillelHomeWork4;

public class ArrayValueCalculator {

    public static int doCalc(String[][] doubleArray)  {
        int sum = 0;
        if (doubleArray.length != 4) {
            throw new ArraySizeException("Wrong size");
        }
        for (int i = 0; i < doubleArray.length; i++) {
            if (doubleArray[i].length != 4) {
                throw new ArraySizeException("Wrong size");
            }
            for (int j = 0; j < doubleArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(doubleArray[i][j]);
                } catch (NumberFormatException ex) {
                    throw new ArrayDataException("Invalid array format in cell: "
                            + "String: " + i + " " + "Column: " + j + " "
                            + "Symbol: " + doubleArray[i][j] + " " + ex);
                }
            }
        }

        return sum;
    }
}