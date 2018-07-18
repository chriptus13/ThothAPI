package model;

public class ThothLink extends ThothResource {
    private final String linkURL;

    protected ThothLink(int id, int classId, String title, String description, String linkURL) {
        super(id, classId, title, description, Type.LINK);
        this.linkURL = linkURL;
    }

    public String getLinkURL() {
        return linkURL;
    }

    @Override
    protected String getDetails() {
        return "Link-URL: \"" + linkURL + '\"';
    }
}
