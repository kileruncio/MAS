import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import taxOffice.Author;
import taxOffice.Director;
import taxOffice.Document;
import taxOffice.TaxOffice;

public class App {
    final static String fileName = "data/data.kfc";

    public static void main(String[] args) {
        List<String> languages0 = new ArrayList<>();
        List<String> languages1 = new ArrayList<>();
        languages0.add("en");
        languages0.add("fr");
        languages1.add("jp");
        languages1.add("hr");

        Tool[] tools = {
                new Tool(null, "machanick", null, 2, languages0),
                new Tool("Bosh", "automatic", "producer", 5, languages1),
                new Hammer("me", "one-hand", null, 1, new ArrayList<>())
        };

        for (Tool it : tools) {
            System.out.println(it.toString());
            System.out.println(it.use());
        }

        System.out.println(Tool.numberOfDifferentTools());

        try {
            var out = new ObjectOutputStream(new FileOutputStream(fileName));
            Tool.writeTools(out);
            out.close();

            var in = new ObjectInputStream(new FileInputStream(fileName));
            Tool.readTools(in);
            in.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("------------------------\n");

        System.out.println(Tool.numberOfDifferentTools());
        System.out.println(Tool.getFromTools());

        // -----------------------MP2-----------------------
        Toolbox toolbox1 = new Toolbox();
        ToolShop toolShop1 = new ToolShop("cheap");
        Owner owner1 = new Owner("alice", "xx-343-yt");

        // normal
        try {
            tools[0].addToToolbox(toolbox1);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println(toolbox1.getTools().toString());

        // attribute
        Transaction transaction = new Transaction(48.24, owner1, toolShop1);
        System.out.println(owner1.getTransactions().toString());
        System.out.println(toolShop1.getTransactions().toString());

        // aggravated
        try {
            owner1.addToolbox("basic", toolbox1);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("Owner has: " + owner1.getToolboxes().toString());

        // composition
        try {
            Part.createPart("screw", tools[0]);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("Parts: " + tools[0].getParts().toString());

        // -----------------------MP4-----------------------

        // atrybut
        TaxOffice taxOffice;
        try {
            taxOffice = new TaxOffice("kajki 3");
            taxOffice.setNumber(5);
            System.out.println(taxOffice.getNumber());
            taxOffice.setNumber(-2);
        } catch (Exception exc) {
            System.out.println(exc);
        }

        // Unique
        try {
            TaxOffice to = new TaxOffice("ladna 2");
            TaxOffice ti = new TaxOffice("kajki 3");
        } catch (Exception exc) {
            System.out.println(exc);
        }

        // Subset
        try {
            TaxOffice to = new TaxOffice("jp2 2");
            Director director1 = new Director();
            Director director2 = new Director();
            to.addDirector(director1);
            to.addDirector(director2);
            to.chooseMainDirector(director2);
            System.out.println(to.getMainDirector());
            to.chooseMainDirector(new Director());
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        // Ordered
        Document d = new Document();
        Document o = new Document();
        Document c = new Document();
        Document u = new Document();
        Document m = new Document();
        Document e = new Document();
        Document n = new Document();
        Document t = new Document();
        Document.showAllDocuments();

        // Bag
        Author[] authors1 = { new Author(0) };
        Author[] authors2 = { new Author(0), new Author(1) };
        Author[] authors3 = { new Author(0), new Author(1), new Author(2) };

        Document doc = new Document(authors1, "zlksmfspdokf");
        Document ume = new Document(authors2, "xdfdvcbcvb");
        Document nt = new Document(authors3, "qwewqrertrtt7ui");

        System.out.println(doc.showRelation());
        System.out.println(ume.showRelation());
        System.out.println(nt.showRelation());

        // Xor
        try {
            Director di = new Director();
            TaxOffice tx = new TaxOffice("k puchatka 3");
            authors1[0].setDirector(di);
            authors2[1].setTaxoffice(tx);
            authors1[0].setTaxoffice(tx);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        // Ograniczenie Własne
        Document cument = new Document();
        System.out.println(cument.getNumberOfCopies());
        cument.makeCopy();
        System.out.println(cument.getNumberOfCopies());
        cument.destoyCopy();
        System.out.println(cument.getNumberOfCopies());
        cument.destoyCopy();
        System.out.println(cument.getNumberOfCopies());
        cument.destoyCopy();
        System.out.println(cument.getNumberOfCopies());
        cument.makeCopy();
        System.out.println(cument.getNumberOfCopies());
    }
}
