package model;

public class ThothBook extends ThothResource{
    private final String isbn;
    private final String authors;

    protected ThothBook(int id, int classId, String title, String description, String isbn, String authors) {
        super(id, classId, title, description, Type.BOOK);
        this.isbn = isbn;
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthors() {
        return authors;
    }

    @Override
    protected String getDetails() {
        return "ISBN: \"" + isbn +
                "\", Authors: \"" + authors + '\"';
    }
}
