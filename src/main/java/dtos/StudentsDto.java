package dtos;

public class StudentsDto {
    private final StudentDto[] students;

    public StudentsDto(StudentDto[] students) {
        this.students = students;
    }

    public StudentDto[] getStudents() {
        return students;
    }
}
