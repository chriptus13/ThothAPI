package model;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ThothClass {
    private final int classId;
    private final String fullName;
    private final String shortName;
    private final int courseUnitId;
    private final String semester;
    private final String className;
    private final Supplier<Teacher> mainTeacher;
    private final Supplier<Stream<Student>> participants;
    private final Supplier<Stream<ThothResource>> resources;

    public ThothClass(int classId, String fullName, String shortName,
                      int courseUnitId, String semester, String className,
                      Supplier<Teacher> mainTeacher, Supplier<Stream<Student>> participants,
                      Supplier<Stream<ThothResource>> resources) {
        this.classId = classId;
        this.fullName = fullName;
        this.shortName = shortName;
        this.courseUnitId = courseUnitId;
        this.semester = semester;
        this.className = className;
        this.mainTeacher = mainTeacher;
        this.participants = participants;
        this.resources = resources;
    }

    public int getClassId() {
        return classId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getCourseUnitId() {
        return courseUnitId;
    }

    public String getSemester() {
        return semester;
    }

    public String getClassName() {
        return className;
    }

    public Teacher getMainTeacher() {
        return mainTeacher.get();
    }

    public Stream<Student> getParticipants() {
        return participants.get();
    }

    public Stream<ThothResource> getResources() {
        return resources.get();
    }

    @Override
    public String toString() {
        return "{ClassID: " + classId +
                ", FullName: \"" + fullName +
                "\", ShortName: \"" + shortName +
                "\", CourseUnitID: " + courseUnitId +
                ", Semester: \"" + semester +
                "\", ClassName: \"" + className + "\"}";
    }
}
