package ua.javaPro.berezhnoy.hillelHomeWork2.part2;

public class Cat extends Animals {
    int maxRun = 200;
    String runStr;
    String swimStr;
    boolean swim = false;


    public Cat(String name) {
        super(name);

    }

    @Override
    public void run(int distanceRun) {
        super.run(distanceRun);
        if (distanceRun > maxRun) {
            runStr = name + " " + "не пробежа " + distanceRun + "м" + ",устал ";
        } else {
            runStr = name + " " + "пробежал " + distanceRun + "м";
        }
    }

    @Override
    public void swim(int distance) {
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
