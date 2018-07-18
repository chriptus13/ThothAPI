package dtos;

public class ClassResourcesDto {
    private final ResourceDto[] classResources;

    public ClassResourcesDto(ResourceDto[] classResources) {
        this.classResources = classResources;
    }

    public ResourceDto[] getClassResources() {
        return classResources;
    }
}
