package dtos;

public class ResourceDto {
    private final int id;
    private final int classId;
    private final String title;
    private final String description;
    private final String type;
    private final ResourceDetails details;

    public ResourceDto(int id, int classId, String title, String description, String type, ResourceDetails details) {
        this.id = id;
        this.classId = classId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public int getClassId() {
        return classId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getFileName() {
        return details==null? "null" : details.getFileName();
    }

    public String getContentType() {
        return details==null? "null" : details.getContentType();
    }

    public String getIsbn() {
        return details==null? "null" : details.getIsbn();
    }

    public String getAuthors() {
        return details==null? "null" : details.getAuthors();
    }

    public String getLinkUrl() {
        return details==null? "null" : details.getLinkUrl();
    }
}
