package dtos;

public class ClassesDto {
    private final ClassDto[] classes;

    public ClassesDto(ClassDto[] classes) {
        this.classes = classes;
    }

    public ClassDto[] getClasses() {
        return classes;
    }
}
