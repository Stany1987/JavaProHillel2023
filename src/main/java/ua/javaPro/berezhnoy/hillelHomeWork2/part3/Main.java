package ua.javaPro.berezhnoy.hillelHomeWork2.part3;

public class Main {
    public static void main(String[] args) {


        Geometry[] figures = new Geometry[3];
        figures[0] = new Circle(18.2);
        figures[1] = new Square(7.1);
        figures[2] = new Triangle(7.3, 12.9);

        System.out.println("Суммарная площадь всех фигур " + allFiguresArea(figures));

    }

    public static double allFiguresArea(Geometry[] arrayFigure) {
        double areaFigures = 0;
        for (Geometry geometry : arrayFigure) {
            areaFigures += geometry.area();
        }
        return areaFigures;
    }
}
