package model;

public class Student {
    private final int id;
    private final int number;
    private final String shortName;
    private final String name;
    private final String email;
    private final String course;

    public Student(int id, int number, String shortName, String name, String email, String course) {
        this.id = id;
        this.number = number;
        this.shortName = shortName;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getShortName() {
        return shortName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "{ID: " + id +
                ", Number: " + number +
                ", ShortName: \"" + shortName +
                "\", Name: \"" + name +
                "\", Email: \"" + email +
                "\", Course: \"" + course + "\"}";
    }
}
