package ua.javaPro.berezhnoy.hillelHomeWork2.part2;

public class Dog extends Animals {
    int maxRun = 500;
    int maxSwim = 10;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distanceRun) {
        if (distanceRun > maxRun) {
            System.out.println(getName() + " " + "Не пробежал " + distanceRun + "м" + ",устал ");
        } else {

            System.out.println(getName() + " " + "Пробежал " + distanceRun + "м");

            runStr = name + " " + "пробежал " + distanceRun + "м";

        }
    }

    @Override
    public void swim(int distance) {
        if (distance > maxSwim) {
            System.out.println(getName() + " " + "Не проплыл " + distance + "м" + " слишком большое растояние ");
        } else {

            System.out.println(getName() + " " + "Проплыл " + distance + "м");

            swimStr = name + " " + "проплыл " + distance + "м";
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

