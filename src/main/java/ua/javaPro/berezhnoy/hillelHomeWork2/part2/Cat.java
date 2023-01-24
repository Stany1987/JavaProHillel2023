package ua.javaPro.berezhnoy.hillelHomeWork2.part2;

public class Cat extends Animals {
    int maxRun = 200;
    String runStr;
    boolean swim = false;

    public Cat(String name, int distanceRun, int distanceSwing) {
        super(name, distanceRun, distanceSwing);
        if (distanceRun > maxRun) {
            runStr = name + " " + "не пробежа " + distanceRun + "м" + ",устал ";
        } else {
            runStr = name + " " + "пробежал " + distanceRun + "м";
        }
        swim = true;
    }

    public Cat(String name, int distanceRun) {
        super(name, distanceRun);
        if (distanceRun > maxRun) {
            runStr = name + " " + "не пробежа " + distanceRun + "м" + ",устал ";
        } else {
            runStr = name + " " + "пробежал " + distanceRun + "м";
        }
    }

    @Override
    public String toString() {
        if (swim) {
            return "Cat{" +
                    "Имя: " + name +
                    ", " + runStr +
                    ", " + name + " " + " утонул , коты не умеют плавать " +
                    '}';
        } else {
            return "Cat{" +
                    "Имя: " + name +
                    ", " + runStr +
                    '}';
        }
    }
}
