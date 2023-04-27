package taxOffice;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private static List<Document> documents = new ArrayList<>();
    private List<DocumentAuthor> authors;
    private int numberOfCopies;

    public Document() {
        this.numberOfCopies = 1;
        documents.add(this);
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public Document(Author[] authors, String edition) {
        this.numberOfCopies = 1;
        documents.add(this);
        setAuthors(authors, edition);
    }

    public void makeCopy(){
        if (this.numberOfCopies > 0)
            this.numberOfCopies++;
    }

    public void destoyCopy(){
        if (this.numberOfCopies >= 1)
            this.numberOfCopies--;
    }

    private void setAuthors(Author[] authors, String edition) {
        this.authors = new ArrayList<>();
        for (Author author : authors) {
            DocumentAuthor da = new DocumentAuthor(edition);
            da.setDocument(this);
            da.setAuthor(author);
            this.authors.add(da);
        }
    }

    public String showRelation() {
        String resoult = "";
        for (DocumentAuthor da : authors) {
            resoult += da.toString() + " || ";
        }
        return resoult;
    }

    public static void showAllDocuments() {
        for (Document d : documents)
            System.out.println(d);
    }
}
