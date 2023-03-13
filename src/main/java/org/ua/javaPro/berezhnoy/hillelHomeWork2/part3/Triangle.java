package org.ua.javaPro.berezhnoy.hillelHomeWork2.part3;

public class Triangle implements Geometry {
    public static final double factor = 0.5;
    private final double  baseTriangle;
    private final double heightTriangle;

    public Triangle(double baseTriangle, double heightTriangle) {
        this.baseTriangle = baseTriangle;
        this.heightTriangle = heightTriangle;
    }

    @Override
    public double area() {
        return factor* baseTriangle * heightTriangle;
    }

}
