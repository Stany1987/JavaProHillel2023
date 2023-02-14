package ua.javaPro.berezhnoy.hillelHomeWork6.phonebook;

public class Recording extends Phonebook {
    public static void main(String[] args) {
        add("Alex", "7784455");
        add("Lisa", "7781122");
        add("Alex", "0935056960");
        add("Alex", "77873922");

        System.out.println(find("Alex", 2));
        System.out.println(find("Alex", 4));
        System.out.println(findAll("Alex"));
        System.out.println(findAll("saefgs"));
    }

}

