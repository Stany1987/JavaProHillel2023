package ua.javaPro.berezhnoy.hillelHomeWork2.part3;

public class Square implements Geometry {
    private double perimeterSquare;
    private double areaSquare;

    public Square(double perimeterSquare) {
        this.perimeterSquare = perimeterSquare;
    }

    @Override
    public double figure() {
        return areaSquare = perimeterSquare * perimeterSquare;
    }
}
