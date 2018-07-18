package dtos;

public class Course {
    private final int id;
    private final String shortName;

    public Course(int id, String shortName) {
        this.id = id;
        this.shortName = shortName;
    }

    int getId() {
        return id;
    }

    String getShortName() {
        return shortName;
    }
}
