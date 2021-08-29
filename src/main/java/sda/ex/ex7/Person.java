package sda.ex.ex7;

public class Person {
    private String name;
    private String middleName;
    private String familyName;
    private String fathersName;
    private String mothersName;
    private double height;

    public Person() {
    }

    public Person(String name, String middleName, String familyName, String fathersName, String mothersName, double height) {
        this.name = name;
        this.middleName = middleName;
        this.familyName = familyName;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Person middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Person familyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public String getFathersName() {
        return fathersName;
    }

    public Person fathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    public String getMothersName() {
        return mothersName;
    }

    public Person mothersName(String mothersName) {
        this.mothersName = mothersName;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public Person height(double height) {
        this.height = height;
        return this;
    }
}
