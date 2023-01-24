package ua.javaPro.berezhnoy.hillelHomeWork2.part2;

public class Main {
    public static void main(String[] args) {
        var barsik = new Cat("Barsik");
        var bobik = new Dog("Bobik");
        var murchik = new Cat("Murchik");
        var bim = new Dog("Bim");
        bobik.run(150);
        bobik.swim(8);
        barsik.run(100);
        barsik.swim(8);
        murchik.run(450);
        bim.run(501);

        System.out.println(bobik);
        System.out.println(barsik);
        System.out.println(murchik);
        System.out.println(bim);
    }
}
