package taxOffice;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private List<DocumentAuthor> documents;
    private int id;
    private TaxOffice taxoffice;
    private Director director;

    public Author(int id) {
        this.id = id;
    }

    public void setTaxoffice(TaxOffice taxoffice) throws Exception {
        if (this.director == null)
            this.taxoffice = taxoffice;
        else
            throw new Exception("Coannot be in relation with director and tax office");
    }

    public void setDirector(Director director) throws Exception {
        if (this.taxoffice == null)
            this.director = director;
        else
            throw new Exception("Coannot be in relation with director and tax office");

    }

    public void setDocuments(DocumentAuthor... documentauthor) {
        this.documents = new ArrayList<>();
        for (DocumentAuthor da : documentauthor) {
            this.documents.add(da);
        }
    }
}
