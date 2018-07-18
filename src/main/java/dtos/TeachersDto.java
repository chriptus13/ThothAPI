package dtos;

public class TeachersDto {
    private final TeacherDto[] teachers;

    public TeachersDto(TeacherDto[] teachers) {
        this.teachers = teachers;
    }

    public TeacherDto[] getTeachers() {
        return teachers;
    }
}
