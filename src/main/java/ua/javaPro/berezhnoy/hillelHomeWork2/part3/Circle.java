package ua.javaPro.berezhnoy.hillelHomeWork2.part3;

import static java.lang.Math.PI;

public class Circle implements Geometry {
    public static final double pi = PI;
    private double radiusCircle;

    public Circle(double radiusCircle) {
        this.radiusCircle = radiusCircle;
    }

    @Override
    public double figure() {
        return pi * (radiusCircle * radiusCircle);
    }
}
