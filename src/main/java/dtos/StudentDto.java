package dtos;

public class StudentDto {
    private final int id;
    private final int number;
    private final String shortName;
    private final String name;
    private final String academicEmail;
    private final Course program;

    public StudentDto(int id, int number, String shortName, String name,
                      String academicEmail, Course program) {
        this.id = id;
        this.number = number;
        this.shortName = shortName;
        this.name = name;
        this.academicEmail = academicEmail;
        this.program = program;
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

    public String getAcademicEmail() {
        return academicEmail;
    }

    public String getCourseName() {
        return program.getShortName();
    }

    public int getCourseId() {
        return program.getId();
    }
}
