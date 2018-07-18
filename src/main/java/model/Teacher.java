package model;

public class Teacher {
    private final int id;
    private final int number;
    private final String shortName;
    private final String fullName;
    private final String email;

    public Teacher(int id, int number, String shortName, String fullName, String email) {
        this.id = id;
        this.number = number;
        this.shortName = shortName;
        this.fullName = fullName;
        this.email = email;
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

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "{ID: " + id +
                ", Number: " + number +
                ", ShortName: \"" + shortName +
                "\", Name: \"" + fullName +
                "\", Email: \"" + email + "\"}";
    }
}
