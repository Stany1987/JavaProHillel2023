package ua.javaPro.berezhnoy.hillelHomeWork2.part3;

public class Triangle implements Geometry {
    public static final double triangle = 0.5;
    private double baseTriangle;
    private double heightTriangle;

    public Triangle(double baseTriangle, double heightTriangle) {
        this.baseTriangle = baseTriangle;
        this.heightTriangle = heightTriangle;
    }

    @Override
    public double figure() {
        return triangle * baseTriangle * heightTriangle;
    }

}
