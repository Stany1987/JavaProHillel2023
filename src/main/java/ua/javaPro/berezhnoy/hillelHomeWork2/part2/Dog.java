package ua.javaPro.berezhnoy.hillelHomeWork2.part2;

public class Dog extends Animals {
    int maxRun = 500;
    int maxSwim = 10;
    String runStr;
    String swimStr;

    public Dog(String name, int distanceRun, int distanceSwing) {
        super(name, distanceRun, distanceSwing);
        if (distanceRun > maxRun) {
            runStr = name + " " + "не пробежа " + distanceRun + "м" + ",устал ";
        } else {
            runStr = name + " " + "пробежал " + distanceRun + "м";
        }
        if (distanceSwing > maxSwim) {
            swimStr = name + " " + "не проплыл " + distanceSwing + "м" + " слишком большое растояние ";
        } else {
            swimStr = name + " " + "проплыл " + distanceSwing + "м";
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "Имя: " + name + ", " +
                runStr + ", " +
                swimStr +
                '}';
    }
}

