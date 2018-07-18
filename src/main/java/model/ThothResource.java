package model;

import dtos.ResourceDto;

public abstract class ThothResource {
    private final int id;
    private final int classId;
    private final String title;
    private final String description;
    private final Type type;

    enum Type {FILE, BOOK, LINK}

    protected ThothResource(int id, int classId, String title, String description, Type type) {
        this.id = id;
        this.classId = classId;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    protected abstract String getDetails();

    public static ThothResource parseResourceDto(ResourceDto resourceDto) {
        String type = resourceDto.getType();
        if(type.equalsIgnoreCase("Book"))
            return new ThothBook(resourceDto.getId(),
                    resourceDto.getClassId(),
                    resourceDto.getTitle(),
                    resourceDto.getDescription(),
                    resourceDto.getIsbn(),
                    resourceDto.getAuthors());
        else if(type.equalsIgnoreCase("File"))
            return new ThothFile(resourceDto.getId(),
                    resourceDto.getClassId(),
                    resourceDto.getTitle(),
                    resourceDto.getDescription(),
                    resourceDto.getFileName(),
                    resourceDto.getContentType());
        else if(type.equalsIgnoreCase("Link"))
            return new ThothLink(resourceDto.getId(),
                    resourceDto.getClassId(),
                    resourceDto.getTitle(),
                    resourceDto.getDescription(),
                    resourceDto.getLinkUrl());
        return null;
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

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{id: " + id +
                ", ClassID: " + classId +
                ", Title: \"" + title +
                "\", Description: \"" + description +
                "\", Type: \"" + type +
                "\", ResourceDetails: {" + getDetails() + "}}";
    }
}
