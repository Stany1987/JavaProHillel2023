package ua.javaPro.berezhnoy.hillelHomeWork2.part2;

public class Dog extends Animals {
    int maxRun = 500;
    int maxSwim = 10;
    String runStr;
    String swimStr;
    boolean swim = false;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distanceRun) {
        super.run(distanceRun);
        if (distanceRun > maxRun) {
            runStr = name + " " + "не пробежал " + distanceRun + "м" + ",устал ";
        } else {
            runStr = name + " " + "Пробежал " + distanceRun + "м";
        }
    }

    @Override
    public void swim(int distance) {
        super.swim(distance);
        swim = true;
        if (distance > maxSwim) {
            swimStr = name + " " + "не проплыл " + distance + "м" + " слишком большое растояние ";
        } else {
            swimStr = name + " " + "Проплыл " + distance + "м";
        }
    }

    @Override
    public String toString() {
        if (swim) {
            return "Dog{" +
                    "Имя: " + name + ", " +
                    runStr + ", " +
                    swimStr +
                    '}';
        } else {
            return "Dog{" +
                    "Имя: " + name + ", " +
                    runStr +
                    '}';
        }
    }
}

