package org.ua.javaPro.berezhnoy.hillelHomeWork2.part2;

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
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " " + "Не проплыл " + distance + "м, " + " коты не умеют плавать.");
    }
}
