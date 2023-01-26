package ua.javaPro.berezhnoy.hillelHomeWork2.part2;

public class Cat extends Animals {
    int maxRun = 200;

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distanceRun) {
        if (distanceRun > maxRun) {
            System.out.println(getName() + " " + "не пробежал " + distanceRun + "м" + ",устал ");
        } else {

            System.out.println(getName() + " " + "Пробежал " + distanceRun + "м");

            runStr = name + " " + "пробежал " + distanceRun + "м";

        }
    }

    @Override
    public void swim(int distance) {

        System.out.println(getName() + " " + "Не проплыл " + distance + "м, " + " коты не умеют плавать.");

        super.swim(distance);
        swimStr =(distance) + "м";
        swim = true;
    }

    @Override
    public String toString() {
        if (swim) {
            return "Cat{" +
                    "Имя: " + name +
                    ", " + runStr +
                    ", кот не проплыл " + swimStr + " , коты не умеют плавать " +
                    '}';
        } else {
            return "Cat{" +
                    "Имя: " + name +
                    ", " + runStr +
                    '}';
        }

    }
}
