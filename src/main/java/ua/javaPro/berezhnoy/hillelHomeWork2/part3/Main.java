package ua.javaPro.berezhnoy.hillelHomeWork2.part3;

public class Main {
    public static void main(String[] args) {


        Geometry[] arrayFigure = new Geometry[3];
        arrayFigure[0] = new Circle(18.2);
        arrayFigure[1] = new Square(7.1);
        arrayFigure[2] = new Triangle(7.3, 12.9);

        System.out.println("Суммарная площадь всех фигур " + allFiguresArea(arrayFigure));

    }

    public static double allFiguresArea(Geometry[] arrayFigure) {
        double areaFigures = 0;
        for (int i = 0; i < arrayFigure.length; i++) {
            areaFigures += arrayFigure[i].figure();
        }
        return areaFigures;
    }
}
