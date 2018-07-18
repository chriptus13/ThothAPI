import com.google.gson.Gson;
import dtos.*;
import util.IRequest;

import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

public class ThothRawAPI {
    private static final String THOTH_URL = "https://adeetc.thothapp.com/api/v1";
    private static final String THOTH_STUDENTS = "/students";
    private static final String THOTH_STUDENT = "/students/{0, number, #}";
    private static final String THOTH_TEACHERS = "/teachers";
    private static final String THOTH_TEACHER = "/teachers/{0, number, #}";
    private static final String THOTH_CLASS = "/classes/{0, number, #}";
    private static final String THOTH_CLASSES = "/classes";
    private static final String THOTH_CLASS_RESOURCES = "/classes/{0, number, #}/resources";
    private static final String THOTH_CLASS_PARTICIPANTS = "/classes/{0, number, #}/participants";

    private static final Gson JSON_CONVERTER = new Gson();

    private IRequest req;

    public ThothRawAPI(IRequest request) {
        req = request;
    }

    public CompletableFuture<TeacherDto[]> getTeachers() {
        return req.getBody(THOTH_URL.concat(THOTH_TEACHERS))
                .thenApply(resp -> JSON_CONVERTER.fromJson(resp, TeachersDto.class).getTeachers());
    }

    public CompletableFuture<TeacherDto> getTeacher(int id) {
        return req.getBody(MessageFormat.format(THOTH_URL + THOTH_TEACHER, id))
                .thenApply(resp -> JSON_CONVERTER.fromJson(resp, TeacherDto.class));
    }

    public CompletableFuture<StudentDto[]> getStudents() {
        return req.getBody(THOTH_URL.concat(THOTH_STUDENTS))
                .thenApply(resp -> JSON_CONVERTER.fromJson(resp, StudentsDto.class).getStudents());
    }

    public CompletableFuture<StudentDto> getStudent(int id) {
        return req.getBody(MessageFormat.format(THOTH_URL + THOTH_STUDENT, id))
                .thenApply(resp -> JSON_CONVERTER.fromJson(resp, StudentDto.class));
    }

    public CompletableFuture<StudentDto[]> getStudentsForClass(int classId) {
        return req.getBody(MessageFormat.format(THOTH_URL + THOTH_CLASS_PARTICIPANTS, classId))
                .thenApply(resp -> JSON_CONVERTER.fromJson(resp, ClassParticipantsDto.class).getStudents());
    }

    public CompletableFuture<ClassDto[]> getClasses() {
        return req.getBody(THOTH_URL.concat(THOTH_CLASSES))
                .thenApply(resp -> JSON_CONVERTER.fromJson(resp, ClassesDto.class).getClasses());
    }

    public CompletableFuture<ClassDto> getClass(int id) {
        return req.getBody(MessageFormat.format(THOTH_URL + THOTH_CLASS, id))
                .thenApply(resp -> JSON_CONVERTER.fromJson(resp, ClassDto.class));
    }

    public CompletableFuture<ResourceDto[]> getClassResources(int id) {
        return req.getBody(MessageFormat.format(THOTH_URL + THOTH_CLASS_RESOURCES, id))
                .thenApply(resp -> JSON_CONVERTER.fromJson(resp, ClassResourcesDto.class).getClassResources());
    }


}
