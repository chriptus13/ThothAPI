package dtos;

public class ClassParticipantsDto {
    private final TeacherDto mainTeacher;
    private final TeacherDto[] otherTeachers;
    private final StudentDto[] students;

    public ClassParticipantsDto(TeacherDto mainTeacher, TeacherDto[] otherTeachers, StudentDto[] students) {
        this.mainTeacher = mainTeacher;
        this.otherTeachers = otherTeachers;
        this.students = students;
    }

    public TeacherDto getMainTeacher() {
        return mainTeacher;
    }

    public TeacherDto[] getOtherTeachers() {
        return otherTeachers;
    }

    public StudentDto[] getStudents() {
        return students;
    }
}
