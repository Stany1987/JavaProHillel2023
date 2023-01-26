package ua.javaPro.berezhnoy.hillelHomeWork2.part1;

public class Employee {
    private final String name;
    private final String lastName;
    private final String patronymic;
    private final String position;
    private final String phoneNumber;
    private final double age;

    public Employee(String name, String lastName, String patronymic, String position, String phoneNumber, int age) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", position='" + position + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
