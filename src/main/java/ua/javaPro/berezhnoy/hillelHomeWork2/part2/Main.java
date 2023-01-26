package ua.javaPro.berezhnoy.hillelHomeWork2.part2;

public class Main {
    public static void main(String[] args) {
        var barsik = new Cat("Barsik");
        var bobik = new Dog("Bobik");
        var murchik = new Cat("Murchik");
        var bim = new Dog("Bim");
        bobik.run(150);
        bobik.swim(8);
        bobik.swim(11);
        barsik.run(100);
        barsik.swim(8);
        murchik.run(400);
        murchik.run(50);
        bim.run(501);
    }
}
