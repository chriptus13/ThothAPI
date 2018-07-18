package dtos;

public class ResourceDetails {
    private final String fileName;
    private final String contentType;
    private final String isbn;
    private final String authors;
    private final String linkUrl;

    public ResourceDetails(String fileName, String contentType, String isbn, String authors, String linkUrl) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.isbn = isbn;
        this.authors = authors;
        this.linkUrl = linkUrl;
    }

    String getFileName() {
        return fileName;
    }

    String getContentType() {
        return contentType;
    }

    String getIsbn() {
        return isbn;
    }

    String getAuthors() {
        return authors;
    }

    String getLinkUrl() {
        return linkUrl;
    }
}