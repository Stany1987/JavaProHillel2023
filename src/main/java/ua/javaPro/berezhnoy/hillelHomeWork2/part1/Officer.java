package ua.javaPro.berezhnoy.hillelHomeWork2.part1;

public class Officer {
    private String name;
    private String lastName;
    private String patronymic;
    private String position;
    private String phoneNumber;
    private double age;

    public Officer(String name, String lastName, String patronymic, String position, String phoneNumber, int age) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", position='" + position + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
