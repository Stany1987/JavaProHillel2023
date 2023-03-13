package org.ua.javaPro.berezhnoy.hillelHomeWork2.part3;

public class Square implements Geometry {
    private final double perimeterSquare;

    public Square(double perimeterSquare) {
        this.perimeterSquare = perimeterSquare;
    }

    @Override
    public double area() {
        return  perimeterSquare * perimeterSquare;
    }
}
