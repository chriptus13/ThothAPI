package model;

public class ThothFile extends ThothResource {
    private final String fileName;
    private final String contentType;

    protected ThothFile(int id, int classId, String title, String description, String fileName, String contentType) {
        super(id, classId, title, description, Type.FILE);
        this.fileName = fileName;
        this.contentType = contentType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    @Override
    protected String getDetails() {
        return "FileName: \"" + fileName +
                "\", Content-Type: \"" + contentType + '\"';
    }
}
