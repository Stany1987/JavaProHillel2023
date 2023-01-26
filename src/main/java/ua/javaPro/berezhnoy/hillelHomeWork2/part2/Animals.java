package ua.javaPro.berezhnoy.hillelHomeWork2.part2;

public abstract class Animals {
    private final String name;

    public String getName() {
        return name;
    }


    public Animals(String  name) {
        this.name = name;

    }

    public abstract void run(int distanceRun);

    public abstract void swim(int distanceSwing) ;


}
