package taxOffice;

public class DocumentAuthor {
    private Author author;
    private Document document;
    private String edition;

    public DocumentAuthor(String edition) {
        this.edition = edition;
    }

    public void setAuthor(Author author) {
        this.author = author;
        this.author.setDocuments(this);
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
