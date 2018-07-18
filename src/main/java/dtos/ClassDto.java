package dtos;

public class ClassDto {
    private final int id;
    private final String fullName;
    private final String courseUnitShortName;
    private final int courseUnitId;
    private final String lectiveSemesterShortName;
    private final String className;
    private final int mainTeacherId;

    public ClassDto(int id, String fullName, String courseUnitShortName, int courseUnitId,
                    String lectiveSemesterShortName, String className, int mainTeacherId) {
        this.id = id;
        this.fullName = fullName;
        this.courseUnitShortName = courseUnitShortName;
        this.courseUnitId = courseUnitId;
        this.lectiveSemesterShortName = lectiveSemesterShortName;
        this.className = className;
        this.mainTeacherId = mainTeacherId;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCourseUnitShortName() {
        return courseUnitShortName;
    }

    public int getCourseUnitId() {
        return courseUnitId;
    }

    public String getLectiveSemesterShortName() {
        return lectiveSemesterShortName;
    }

    public String getClassName() {
        return className;
    }

    public int getMainTeacherId() {
        return mainTeacherId;
    }
}
