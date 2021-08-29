package sda.ex.ex7;

public class Main {
    public static void main(String[] args) {
        Person veryImportantPerson = new Person();

        veryImportantPerson
                .familyName("Kowalski")
                .middleName("Roman")
                .name("Andrzej");
    }
}