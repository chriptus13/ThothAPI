import dtos.ClassDto;
import dtos.ResourceDto;
import dtos.StudentDto;
import dtos.TeacherDto;
import model.Student;
import model.Teacher;
import model.ThothClass;
import model.ThothResource;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ThothAPI {
    private final ThothRawAPI rawAPI;

    public ThothAPI(ThothRawAPI rawAPI) {
        this.rawAPI = rawAPI;
    }

    public CompletableFuture<Teacher> getTeacher(int id) {
        return rawAPI.getTeacher(id).thenApply(this::parseTeacherDto);
    }

    public CompletableFuture<ThothClass> getThothClass(int classId) {
        return rawAPI.getClass(classId).thenApply(this::parseClassDto);
    }

    public CompletableFuture<Stream<ThothClass>> getThothClasses() {
        return rawAPI.getClasses()
                .thenApply(classesDto -> Arrays.stream(classesDto).map(this::parseClassDto));
    }

    public CompletableFuture<Stream<Student>> getStudentsForClass(int classId) {
        return rawAPI.getStudentsForClass(classId)
                .thenApply(studentsDto -> Arrays.stream(studentsDto).map(this::parseStudentDto));
    }

    public CompletableFuture<Stream<ThothResource>> getThothClassResources(int classId) {
        return rawAPI.getClassResources(classId)
                .thenApply(resourcesDto -> Arrays.stream(resourcesDto).map(this::parseResourceDto));
    }

    private ThothResource parseResourceDto(ResourceDto resourceDto) {
        return ThothResource.parseResourceDto(resourceDto);
    }

    private Student parseStudentDto(StudentDto studentDto) {
        return new Student(studentDto.getId(),
                studentDto.getNumber(),
                studentDto.getShortName(),
                studentDto.getName(),
                studentDto.getAcademicEmail(),
                studentDto.getCourseName());
    }

    private Teacher parseTeacherDto(TeacherDto teacherDto) {
        return new Teacher(teacherDto.getId(),
                teacherDto.getNumber(),
                teacherDto.getShortName(),
                teacherDto.getFullName(),
                teacherDto.getAcademicEmail());
    }

    private ThothClass parseClassDto(ClassDto classDto) {
        return new ThothClass(classDto.getId(),
                classDto.getFullName(),
                classDto.getCourseUnitShortName(),
                classDto.getCourseUnitId(),
                classDto.getLectiveSemesterShortName(),
                classDto.getClassName(),
                () -> getTeacher(classDto.getMainTeacherId()).join(),
                () -> StreamSupport.stream(() -> getStudentsForClass(classDto.getId()).join().spliterator(), Spliterator.DISTINCT + Spliterator.IMMUTABLE, false),
                () -> StreamSupport.stream(() -> getThothClassResources(classDto.getId()).join().spliterator(), Spliterator.DISTINCT + Spliterator.IMMUTABLE, false));
    }
}
