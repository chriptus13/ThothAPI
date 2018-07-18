package dtos;

public class TeacherDto {
    private final int id;
    private final int number;
    private final String shortName;
    private final String fullName;
    private final String academicEmail;

    public TeacherDto(int id, int number, String shortName, String fullName, String academicEmail) {
        this.id = id;
        this.number = number;
        this.shortName = shortName;
        this.fullName = fullName;
        this.academicEmail = academicEmail;
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

    public String getAcademicEmail() {
        return academicEmail;
    }
}
