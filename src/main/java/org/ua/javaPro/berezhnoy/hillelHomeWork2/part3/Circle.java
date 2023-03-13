package org.ua.javaPro.berezhnoy.hillelHomeWork2.part3;

import static java.lang.Math.PI;

public class Circle implements Geometry {
    private final double radiusCircle;

    public Circle(double radiusCircle) {
        this.radiusCircle = radiusCircle;
    }

    @Override
    public double area() {
        return PI * (radiusCircle * radiusCircle);
    }
}
